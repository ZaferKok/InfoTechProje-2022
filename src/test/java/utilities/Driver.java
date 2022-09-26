package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.PageInitializer;

import java.time.Duration;

public class Driver {

    public static WebDriver driver; // selenium dependency bunun icin gerekli

    public static WebDriver getDriver(){

        if(driver==null){

            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup(); // bonogarcia dependency bunun için gerekli
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver= new EdgeDriver();
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }
        }
        driver.manage().window().maximize();
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