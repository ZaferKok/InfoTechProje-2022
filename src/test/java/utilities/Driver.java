package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import pages.PageInitializer;

import java.time.Duration;

public class Driver {

    public static WebDriver driver; // selenium dependency bunun icin gerekli

    public static WebDriver getDriver(){

        if(driver==null){

            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                default:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    WebDriverManager.chromedriver().setup(); // bonogarcia dependency bunun için gerekli
                    driver = new ChromeDriver(chromeOptions);
                    System.out.println("CHROME WORKS!!!");
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    driver.manage().window().maximize();
                    System.out.println("CHROME-HEADLESS WORKS!!!");
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("start-maximized");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    System.out.println("FIREFOX WORKS!!!");
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    driver.manage().window().maximize();
                    System.out.println("FIREFOX-HEADLESS WORKS!!!");
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("start-maximized");
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver(edgeOptions);
                    System.out.println("EDGE WORKS!!!");
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    break;
            }
        }
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void closeDriver() {
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }

    public static void wait(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
Singleton, yazılımlarda sıklıkla karşımıza çıkan ve bir sınıftan sadece ve sadece bir tane nesnenin bulunması
gereken durumlara bir çözümdür. Bir sınıftan bir tane nesne olmasından kasıt ise, herkesin istediği zaman bu
sınıfın bir nesnesini oluşturmaya çalışmamasıdır, oluşturamamasıdır. “Bir sınıfın sadece bir tane nesnesinin
olduğundan emin ol” ile kastedilen budur.

Böyle bir durumla çok sık karşılaşırız. Arka taraftaki sisteme erişimleri kontrol eden yapıdan sadece bir tane
olması istenir. Çünkü, bu tür nesneler trafik polisi gibi geçişi kontrol ederler, arka taraftaki sistemin
vereceği hizmetlerin alınmasını düzenlerler vs.
 */