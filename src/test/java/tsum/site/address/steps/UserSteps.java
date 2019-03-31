package tsum.site.address.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import tsum.site.address.model.UserAddress;
import tsum.site.address.model.UserData;
import tsum.site.address.pages.AddressPage;
import tsum.site.address.pages.LoginPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserSteps extends ScenarioSteps {

    public boolean checkAddressIsExistsBoolean;
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
        boolean actual = addressPage.lookToAddress();
        Assert.assertEquals(actual, true);
    }
    @Step
    public boolean checkAddressIsExistsBoolean() {
        boolean actual = addressPage.lookToAddress();
        return actual;
    }
    @Step
    public void checkAddressIsDelete() {
        boolean actual = addressPage.lookToAddress();
        Assert.assertEquals(actual, false);
    }
    @Step
    public void chooseMainAddress(int num){
        addressPage.chooseRadioButton(num);
    }
    @Step
    public void addNewAddress() {
        addressPage.addNewAddressButton();
    }

    @Step
    public void checkAddressesIsExists(int countAddresses) {
        int actualCount = addressPage.getAddressesCount();
        Assert.assertEquals(actualCount,countAddresses);
    }
    @Step
    public void checkAddressIsMain(int whichNumAddress) {
        addressPage.addressPositionInRow(whichNumAddress);
    }
    @Step
    public void checkAddressFieldsIsNotAvailable() {
        ArrayList<Boolean> actualAddressFields = addressPage.getAddressFieldsEnabled();
        List<Boolean> expectedAddressFields = Arrays.asList(true, false, false, false);
        Assert.assertEquals(actualAddressFields,expectedAddressFields);
    }
    @Step
    public void checkButtonAddAddressIsNotAvailable() {
        boolean actual = addressPage.lookToButtonAddAddressEnable();
        Assert.assertEquals(actual,false);
        //Assert

    }
    @Step
    public void clearAddressField(String fieldName){
        addressPage.clearField(fieldName);
    }
    @Step
    public void checkFieldContainsText(String field, String fieldText) {
        String actualText = addressPage.getAddressTextField(field);
        Assert.assertEquals(actualText, fieldText);
    }


    public void deleteAllAddresses() {
        //sql-query for delete addresses before tests.
        //DELETE FROM Database.user_addresses
        //WHERE user='wegavoruxe@easyemail.info';
        //if we can't see DB then... Take count addresses(if exists) and delete by for cycle. after check count addresses = 0
    }
}

