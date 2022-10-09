package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"summary", "pretty",
                "json:target/json/cucumber.json",
                "json:target/cucumber.json",
                "html:target/cucumber-default-report",
                "rerun:target/failed.txt",
                  "junit:target/xml-report/cucumber.xml",
                  "timeline:test-output-thread/",
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },

        features = "src/test/resources",
        glue = "stepdefinitions",
        tags = "@db",
        dryRun = false
)

public class DB_TestRunner {
}
