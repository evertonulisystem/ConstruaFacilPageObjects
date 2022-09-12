package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test // junité Runwith,,,,
@CucumberOptions(
        features = {"src/test/resources/featuresPO"},
        glue = {"steps"},
        dryRun = false, //volte para true desabilitado screen hot
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/reports/extentreports.html",
                "json:target/reports/extentreports.json",
                //"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"
        }
)

public class Runner extends AbstractTestNGCucumberTests {

}

