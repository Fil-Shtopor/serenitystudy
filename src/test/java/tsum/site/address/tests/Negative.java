package tsum.site.address.tests;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;/*
import net.thucydides.showcase.junit.model.ListingItem;
import net.thucydides.showcase.junit.steps.serenity.BuyerSteps;*/
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tsum.site.address.model.UserData;
import tsum.site.address.steps.UserSteps;

@RunWith(SerenityRunner.class)
public class Negative {

        @Managed(driver = "chrome" )
        public WebDriver driver;

        @Steps
        UserSteps user;

        @Before
        public void Login () {
                user.openLoginPage();
                user.loginToSite(new UserData("wegavoruxe@easyemail.info", "12345678"));
                //user.goToAddressPage();

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
