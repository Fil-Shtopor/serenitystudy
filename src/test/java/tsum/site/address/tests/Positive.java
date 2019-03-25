package tsum.site.address.tests;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WhenPageOpens;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import tsum.site.address.fixtures.DriverManager;
import tsum.site.address.fixtures.Fixtures;
import tsum.site.address.model.UserAddress;
import tsum.site.address.model.UserData;
import tsum.site.address.steps.UserSteps;

import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@RunWith(SerenityRunner.class)
public class Positive{

    //  @Managed(driver = "firefox" )
        @Managed(driver = "chrome" )
        public WebDriver driver;

        @Steps
        UserSteps user;

        @Test
        public void testLogin () {
        user.openLoginPage();
        user.loginToSite(new UserData("wegavoruxe@easyemail.info", "12345678"));
        //user.goToAddressPage();

    }

        @Test
        public void testAddOneAddress() {
//            user.openAddressPage();
            user.goToAddressPage();
            user.fillAddressFields(new UserAddress("Москва","Ленина","4","56"));
            user.clickAddButton();
            user.checkAddressIsExists();
        }

        @Test
        public void testDeleteAddress(){
            user.clickEditButton();
            user.clickDeleteButton();
            user.checkAddressIsDelete();
        }

        @Test
        public void testAddThreeAddresses(){
            user.fillAddressFields(new UserAddress("Москва","Вилиса Лациса","4","56"));
            user.clickAddButton();

            user.addNewAddress();
            user.fillAddressFields(new UserAddress("Питер","Ленина","4","56"));
            user.clickAddButton();

            user.addNewAddress();
            user.fillAddressFields(new UserAddress("Сургут","Грибоедова","4","56"));
            user.clickAddButton();

            user.checkAddressesIsExists(3);
        }

        @Test
        public void testChangeMainAddress(){
            user.chooseMainAddress(2);
            user.checkAddressIsMain(2);
        }
/*
        @Test
        public void add_item_to_cart() {
            // GIVEN
            buyer.opens_home_page();
            buyer.searches_by_keyword("docking station");
            buyer.filters_by_local_region();

            // WHEN
            ListingItem selectedItem = buyer.selects_listing(2);
            buyer.adds_current_listing_to_cart();

            // THEN
            buyer.should_see_item_in_cart(selectedItem);
            buyer.should_see_total_including_shipping_for(selectedItem);
        }
    }*/






}
