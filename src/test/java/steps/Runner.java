package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test // junité Runwith,,,,
@CucumberOptions(
        features = {"src/test/resources/featuresPO"},
        glue = {"steps"},
        dryRun = false, //volte para true desabilitado screen hot
        monochrome = false,
        plugin = {
                "pretty",
                "html:target/reports/extentreports.html",
                "json:target/reports/extentreports.json"
                //"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"

        })

public class Runner extends AbstractTestNGCucumberTests {

}

