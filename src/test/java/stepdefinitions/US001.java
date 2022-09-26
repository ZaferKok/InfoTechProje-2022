package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US001 {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();


    @Given("Medunna ana sayfasina gider")
    public void medunnaAnaSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @And("Ana sayfa giris ikonuna tiklar")
    public void anaSayfaGirisIkonunaTiklar() {
        homePage.userIcon.click();
        //Driver.wait(1);
    }

    @And("Register butonuna tiklar")
    public void registerButonunaTiklar() {
        homePage.register.click();
        //Driver.wait(1);
    }

    @And("SSN kutusuna uygun ssn girer")
    public void ssnKutusunaUygunSsnGirer() {
        String fakeSSN = faker.random().nextInt(100,899) + "-" + faker.random().nextInt(10,99) + "-" + faker.random().nextInt(1000,9999);
        registerPage.SSN.sendKeys(fakeSSN + Keys.TAB);
       // Driver.wait(1);
    }

    @Then("Hata mesajinin cikmadigini test eder")
    public void hataMesajininCikmadiginiTestEder() {
        Assert.assertFalse(registerPage.ssnDogrulama.isDisplayed());
      //  Driver.wait(1);
    }

    @And("Tarayiciyi kapatir")
    public void tarayiciyiKapatir() {
       // Driver.closeDriver();
    }
}

