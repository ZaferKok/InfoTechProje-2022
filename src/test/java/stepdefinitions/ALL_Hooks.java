package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.PageInitializer;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ALL_Hooks {

    @Before
    public void start() {
        Driver.getDriver();
        PageInitializer.initialize();
    }

    // Attaching the screenshot to the scenarios in the default-cucumber-reports.html
    @After
    public void tearDown(Scenario scenario) {

        final byte[] picture;
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);

        if (scenario.isFailed()) {

            String destination = System.getProperty("user.dir") + "/test-output/Screenshots/failed/" + scenario.getName() + date + ".png";

            try {
                FileUtils.copyFile(file, new File(destination));
            } catch (IOException e) {
                e.printStackTrace();
            }

            picture = (ts.getScreenshotAs(OutputType.BYTES));
            scenario.attach(picture, "image/png", scenario.getName());


        } else {

            String destination = System.getProperty("user.dir") + "/test-output/Screenshots/passed/" + scenario.getName() + date + ".png";

            try {
                FileUtils.copyFile(file, new File(destination));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //picture = (ts.getScreenshotAs(OutputType.BYTES));
            //scenario.attach(picture, "image/png", scenario.getName());

        }
        Driver.closeDriver();
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
