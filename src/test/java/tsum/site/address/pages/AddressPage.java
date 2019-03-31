package tsum.site.address.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import tsum.site.address.model.UserAddress;

import java.util.ArrayList;

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
        if (!(userAddress.street == null)) {
            street.sendKeys(userAddress.street);
            chooseFirstElemList();
        }
        if (!(userAddress.houseNum == null)) {
            houseNum.sendKeys(userAddress.houseNum);
            chooseFirstElemList();
        }
        if (!(userAddress.apartmentNum == null)) {
            apartmentNum.sendKeys(userAddress.apartmentNum);
        }
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

    public boolean lookToAddress() {
        return addressString.isPresent();
    }

    public void chooseRadioButton(int num){
        WebElementFacade radioButton = $("div.personal-address:nth-child("+ num +") > div:nth-child(1) > label:nth-child(2)");
        radioButton.click();
    }

    public void addNewAddressButton() {
        addNewAddressButton.click();
    }

    public int getAddressesCount() {

        WebElementFacade radioButtons = (WebElementFacade) $("//div[3]/div[2]/personal-address/div[2]/div[1]/div/div[1]/label").getSize();
        int actualCount = Integer.parseInt(radioButtons.toString());
        return actualCount;

    }

    public void addressPositionInRow(int Position) {
        //TODO
    }

    public ArrayList<Boolean> getAddressFieldsEnabled() {
        ArrayList<Boolean> addressFields = new ArrayList<Boolean>();
        addressFields.add(city.isEnabled());
        addressFields.add(street.isEnabled());
        addressFields.add(houseNum.isEnabled());
        addressFields.add(apartmentNum.isEnabled());

        return addressFields;

    }

    public String getAddressTextField(String field) {
        String textInField = new String();

        switch (field) {
            case "city":
                textInField = city.getText();
                break;
            case "street":
                textInField = street.getText();
                break;
            case "houseNum":
                textInField = houseNum.getText();
                break;
            case "apartmentNum":
                textInField = apartmentNum.getText();
                break;
        }
        return textInField;
    }

    public boolean lookToButtonAddAddressEnable() {
        return addButton.isEnabled();
        }

    public void clearField(String fieldName) {
        switch (fieldName) {
            case "city":
                city.clear();
                break;
            case "street":
                street.clear();
                break;
            case "houseNum":
                houseNum.clear();
                break;
            case "apartmentNum":
                apartmentNum.clear();
                break;
        }
    }
}
