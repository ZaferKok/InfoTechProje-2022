package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.PageInitializer;
import utilities.CommonSteps;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ALL_Hooks {

    static int stepCount;

    @Before
    public void start() {
        Driver.getDriver();
        PageInitializer.initialize();
    }

    // Attaching the screenshot to the scenarios in the default-cucumber-reports.html
    @After
    public void tearDown(Scenario scenario) {

        byte[] picture;
        if (scenario.isFailed()) {
            picture = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(picture, "image/png", "failed" + scenario.getName());
        }
        else {
            picture = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(picture, "image/png", "passed" + scenario.getName());
        }
        Driver.closeDriver();
    }

    @AfterStep
    public void makeSlowRunning(){
        //Driver.wait(3);
        this.stepCount = stepCount + 1;
        System.out.println((stepCount) + ". STEP");
    }

    //    @Before("@db")
    //    public void dbHook() {
    //        System.out.println("creating database connection");
    //        DBUtils.createConnection();
    //
    //    }
    //
    //    @After("@db")
    //    public void afterDbHook() {
    //        System.out.println("closing database connection");
    //        DBUtils.destroyConnection();
    //
    //    }
}
