package cucumber;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Test",
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"cucumber.post.stepDef"}
)
public class CucumberTestSuite {
}
