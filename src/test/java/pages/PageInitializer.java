package pages;

import utilities.Driver;

public class PageInitializer extends Driver {

    public static HomePage homePage;
    public static RegisterPage registerPage;

    public static void initialize() {

        homePage = new HomePage();
        registerPage = new RegisterPage();

    }
}
