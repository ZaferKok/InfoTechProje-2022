package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegisterPage {
    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//input[@id='ssn']")
    public WebElement SSN;

    @FindBy(xpath="//input[@class='is-touched is-dirty av-valid form-control']")
    public WebElement ssnDogrulama;

    @FindBy(xpath="//input[@id='firstName']")
    public WebElement firstName;

    @FindBy(xpath="//input[@id='lastName']")
    public WebElement lastName;

    @FindBy(xpath="//input[@id='username']")
    public WebElement username;

    @FindBy(xpath="//input[@id='email']") public WebElement email;

    @FindBy(xpath="//input[@id='firstPassword']")
    public WebElement newPassword;

    @FindBy(xpath="//input[@id='secondPassword']")
    public WebElement newPasswordConfirmation;

    @FindBy(xpath="//button[@id='register-submit']//span[contains(text(),'Register')]")
    public WebElement register;

}
