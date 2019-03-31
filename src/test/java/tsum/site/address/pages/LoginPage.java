package tsum.site.address.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tsum.site.address.model.UserData;

@DefaultUrl("https://www.tsum.ru/login/")
public class LoginPage extends PageObject{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    /*        .login-input
            .pwd-input
            .ui-button
    */


    @FindBy(css = ".login-input")
    WebElementFacade login;
    @FindBy(css = ".pwd-input")
    WebElementFacade password;
    @FindBy(css = ".ui-button")
    WebElementFacade loginButton;
    @FindBy(css = "li.personal__nav-item:nth-child(2) > a:nth-child(1) > svg:nth-child(1)")
    WebElementFacade gotoAddressPage;
    @FindBy(css = ".ui-button_theme_quite-black")
    WebElementFacade cityOKbutton;

    /*public LoginPage(WebDriver driver) {
        super(driver);
    }*/


    public void login(UserData userData) {
//        login;
//        wegavoruxe@easyemail.
        if (cityOKbutton.isVisible()) {
            cityOKbutton.click();
        }

        login.sendKeys(userData.login);
        password.sendKeys(userData.password);
        loginButton.click();
    }

    public void goToAddressPage(){
        gotoAddressPage.click();
        $("personal-address-suggest.ng-untouched > input:nth-child(1)").isPresent();
       /* WebDriver driver = getDriver();
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("personal-address-suggest.ng-untouched > input:nth-child(1)")));*/
    }
}
