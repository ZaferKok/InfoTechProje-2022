package pages;

import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage extends BasePageForAll{

    // public HomePage() {
    //    PageFactory.initElements(Driver.getDriver(), this);
    // }

    @FindBy(xpath="//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement userIcon;

    @FindBy(xpath="//span[normalize-space()='Sign in']")
    public WebElement signIn;

    @FindBy(xpath="//span[normalize-space()='Register']")
    public WebElement register;

}
