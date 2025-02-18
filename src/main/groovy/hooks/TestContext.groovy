package hooks

import pages.*
import com.microsoft.playwright.*
import io.cucumber.java.Before
import io.cucumber.java.After

class TestContext {

    static Playwright playwright
    static Browser browser
    static BrowserContext context
    static Page page
    static Properties properties
    static CartModal cartModal
    static JacketsShoppingPage jacketsShoppingPage
    static NavBar navBar
    static HomePage homePage
    static ShippingPage shippingPage
    static SignInPage signInPage
    static ShippingPageLoggedinUser shippingPageLoggedinUser

    // Combined Hook to load environment data and set up the browser and page
    @Before
    void setup() {
        if (playwright == null) {
            // Initialize Playwright and browser only if not already initialized
            playwright = Playwright.create()
            String env = System.getProperty("env", "staging")
            println "Environment: ${env}"

            properties = new Properties()

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

            // Debug print for environment variables
            println "Properties loaded:"
            properties.each { key, value ->
                println "${key} = ${value}"
            }

            String baseUrl = properties.getProperty("base.url")
            if (baseUrl == null || baseUrl.isEmpty()) {
                println "Error: base.url not found in properties file"
            }

            println "Base URL: ${baseUrl}"

            // Set up the browser and page in an incognito context
            if (baseUrl != null && !baseUrl.isEmpty()) {
                String browserType = properties.getProperty("browser", "chromium")
                boolean headless = properties.getProperty("headless", "false").toBoolean()

                // Initialize Playwright and launch the browser
                BrowserType type = playwright."${browserType}"()
                browser = type.launch(new BrowserType.LaunchOptions().setHeadless(headless))

                // Each new context is isolated (i.e. incognito/private mode)
                context = browser.newContext()
                page = context.newPage()

                // Navigate to the base URL
                page.navigate(baseUrl)

                // Instantiate the page classes with the page object
                cartModal = new CartModal(page)
                jacketsShoppingPage = new JacketsShoppingPage(page)
                navBar = new NavBar(page)
                homePage = new HomePage(page)
                shippingPage = new ShippingPage(page)
                signInPage = new SignInPage(page)
                shippingPageLoggedinUser = new ShippingPageLoggedinUser(page)
            }
        }
    }

    // Hook to close resources after tests
    @After
    void teardown() {
        // Proper cleanup of resources
        if (page != null) {
            page.close()
            page = null
        }
        if (browser != null) {
            browser.close()
            browser = null
        }
        if (playwright != null) {
            playwright.close()
            playwright = null
        }
    }
}
