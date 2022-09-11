package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test // junité Runwith,,,,
@CucumberOptions(
        features = {"src/test/resources/featuresPO/"},
        glue = {"steps"},
        dryRun = false, //volte para true desabilitado screen hot
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/reports/extentreports",
                "json:target/reports/extentreports.json"
        })

public class Runner extends AbstractTestNGCucumberTests {

}

