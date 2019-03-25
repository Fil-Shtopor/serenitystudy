package tsum.site.address.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import tsum.site.address.model.UserAddress;
import tsum.site.address.model.UserData;
import tsum.site.address.pages.AddressPage;
import tsum.site.address.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class UserSteps extends ScenarioSteps {

    LoginPage loginPage;
    AddressPage addressPage;

    @Step
    public void openLoginPage(){
        loginPage.open();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Step
    public void loginToSite(UserData userData){
        loginPage.login(userData);
    }

    @Step
    public void openAddressPage() {
        addressPage.open();
    }

    @Step
    public void goToAddressPage() {
        loginPage.goToAddressPage();
    }

    @Step
    public void fillAddressFields(UserAddress userAddress) {
        addressPage.fillAddress(userAddress);
    }

    @Step
    public void chooseFirstCity() {
        addressPage.chooseFirstElemList();
    }

    @Step
    public void clickAddButton() {
        addressPage.clickAddButton();
    }

    @Step
    public void clickEditButton() {
        addressPage.clickEditButton();
    }
    @Step
    public void clickDeleteButton() {
        addressPage.clickDeleteButton();
    }
    @Step
    public void checkAddressIsExists() {
        addressPage.lookToAddress(true);
    }
    @Step
    public void checkAddressIsDelete() {
        addressPage.lookToAddress(false);
    }

    @Step
    public void chooseMainAddress(int num){
        addressPage.chooseRadioButton(num);
    }

    @Step
    public void addNewAddress() {
        addressPage.addNewAddressButton();
    }

    public void checkAddressesIsExists(int countAddresses) {
        addressPage.addressesCount(countAddresses);
    }

    public void checkAddressIsMain(int whichNumAddress) {
        addressPage.addressPositionInRow(whichNumAddress);
    }
}

