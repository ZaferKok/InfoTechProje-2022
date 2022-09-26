package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasePageForAll extends Driver {
    public BasePageForAll() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
