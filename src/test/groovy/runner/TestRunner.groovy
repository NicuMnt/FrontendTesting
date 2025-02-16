package runner

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber)
@CucumberOptions(
        features = "src/test/groovy/features",
        glue = ["steps", "hooks"],
        plugin = ["pretty"]
)
class TestRunner {
}
