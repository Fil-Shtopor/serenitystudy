package tsum.site.address.tests;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tsum.site.address.model.UserAddress;
import tsum.site.address.steps.UserSteps;

@RunWith(SerenityRunner.class)

public class Negative{

        @Managed(driver = "firefox" )
        public WebDriver driver;

        @Steps
        UserSteps user;

        @Before
         public void setUpTest() {
            user.goToAddressPage();
            if (user.checkAddressIsExistsBoolean == true){
                user.addNewAddress();
            }
        }

        @Test
        public void IncorrectCity() {
            user.fillAddressFields(new UserAddress("ГородКоторогоНет",null,null,null));
            user.checkAddressFieldsIsNotAvailable();
            user.checkButtonAddAddressIsNotAvailable();
        }

        @Test
        public void IncorrectStreet() {
            user.fillAddressFields(new UserAddress("Москва","УлицаКоторойНет",null,null));
            user.checkButtonAddAddressIsNotAvailable();
        }

        @Test
        public void fillAndDeleteHouseNum(){
            user.fillAddressFields(new UserAddress("Москва","Мясницкая","3",null));
            user.clearAddressField("houseNum");
            user.checkButtonAddAddressIsNotAvailable();
        }

        @Test
        public void fillCityOnEnglishBoard(){
            user.fillAddressFields(new UserAddress("Vjcrdf",null,null,null));
            user.checkFieldContainsText("city","г Москва");
        }

}
