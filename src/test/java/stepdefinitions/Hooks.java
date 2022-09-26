package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {


    @Before
//    public void start() {
//        Driver.getDriver();
//    }

    @After
    public void tearDown(Scenario scenario) {

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();

        String destination = System.getProperty("user.dir") + "/test-output/Screenshots/" + scenario.getName() + date + ".png";
        File file = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//       Attaching the screenshot to the scenarios in the default-cucumber-reports.html

        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "Screenshot");
        }

      //  Driver.closeDriver();
    }

}
