package tsum.site.address.pages;

import com.google.common.base.Function;
import com.sun.xml.bind.v2.TODO;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tsum.site.address.model.UserAddress;
import tsum.site.address.model.UserData;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.tsum.ru/personal/address/")
public class AddressPage extends PageObject{
    UserAddress userAddress;

    @FindBy(css = "personal-address-suggest.ng-untouched > input:nth-child(1)")
    WebElementFacade city;
    @FindBy(css = "div.row-elements:nth-child(2) > div:nth-child(2) > input:nth-child(1)")
    WebElementFacade street;
    @FindBy(css = "div.row-elements:nth-child(3) > div:nth-child(1) > input:nth-child(1)")
    WebElementFacade houseNum;
    @FindBy(css = ".flat-input > input:nth-child(1)")
    WebElementFacade apartmentNum;
    @FindBy(css = ".ui-button")
    WebElementFacade addButton;
    @FindBy(css = "button.personal-address-button:nth-child(5)")
    WebElementFacade editButton;
    @FindBy(css = "button.ui-button:nth-child(1)")
    WebElementFacade deleteButton;
    @FindBy(css = ".personal-address-string")
    WebElementFacade addressString;
    @FindBy(css = ".add-address-link > span:nth-child(1)")
    WebElementFacade addNewAddressButton;




    public void fillAddress(UserAddress userAddress){
        city.sendKeys(userAddress.city);
        chooseFirstElemList();
        street.sendKeys(userAddress.street);
        chooseFirstElemList();
        houseNum.sendKeys(userAddress.houseNum);
        chooseFirstElemList();
        apartmentNum.sendKeys(userAddress.apartmentNum);
    }

    public void chooseFirstElemList() {
        WebElementFacade list = $("/html/body/app-root/div/full-layout/div/div/personal/div/div[3]/div[2]/personal-address/div/address-add/form/div[2]/div[1]/personal-address-suggest/div/div[1]");
        if (list.isPresent()) {
            list.click();
        }

       // $("div.options-list__el:nth-child(1)").click();
      //  find(By.cssSelector("div.options-list__el:nth-child(2)")).click();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void lookToAddress(boolean present) {
        boolean isAddressPresent = addressString.isPresent();
        Assert.assertEquals(isAddressPresent, present);
    }

    public void chooseRadioButton(int num){
        WebElementFacade radioButton = $("div.personal-address:nth-child("+ num +") > div:nth-child(1) > label:nth-child(2)");
        radioButton.click();
    }

    public void addNewAddressButton() {
        addNewAddressButton.click();
    }

    public void addressesCount(int countAddresses) {
        WebElementFacade actualCount = $("count(/html/body/app-root/div/full-layout/div/div/personal/div/div[3]/div[2]/personal-address/div[2]/div[1]/div[1])");
        Assert.assertEquals(actualCount,countAddresses);

    }

    public void addressPositionInRow(int Position) {

    }
}
