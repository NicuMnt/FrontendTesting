package hooks

import com.microsoft.playwright.*
import io.cucumber.java.Before
import io.cucumber.java.After

import java.util.Properties

class PlaywrightHooks {
    static Playwright playwright
    static Browser browser
    static BrowserContext context
    static Page page
    static Properties properties


    @Before
    void setup() {
        String env = System.getProperty("env", "staging")
        println "Environment: ${env}"

        properties = new Properties()

        // Debug prints for env properties loading
        try {
            File configFile = new File("src/test/resources/config/${env}.properties")
            if (configFile.exists()) {
                println "Loading properties from: ${configFile}"
                properties.load(new FileInputStream(configFile))
            } else {
                println "Error: Properties file not found at ${configFile}"
            }
        } catch (Exception e) {
            println "Error loading properties file: ${e.message}"
        }

        // Print all properties
        println "Properties loaded:"
        properties.each { key, value ->
            println "${key} = ${value}"
        }


        String baseUrl = properties.getProperty("base.url")
        if (baseUrl == null || baseUrl.isEmpty()) {
            println "Error: base.url not found in properties file"
        }

        println "Base URL: ${baseUrl}"

        if (baseUrl != null && !baseUrl.isEmpty()) {
            String browserType = properties.getProperty("browser", "chromium")
            boolean headless = properties.getProperty("headless", "false").toBoolean()

            // Initialize Playwright and browser
            playwright = Playwright.create()
            BrowserType type = playwright."${browserType}"()
            browser = type.launch(new BrowserType.LaunchOptions().setHeadless(headless))
            context = browser.newContext()
            page = context.newPage()

            // Navigate to the base URL
            page.navigate(baseUrl)
        }
    }


    @After
    void teardown() {
        page?.close()
        browser?.close()
        playwright?.close()
    }
}
