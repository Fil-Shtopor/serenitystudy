package tsum.site.address.suites;

import net.thucydides.core.annotations.Steps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tsum.site.address.model.UserData;
import tsum.site.address.steps.UserSteps;
import tsum.site.address.tests.Negative;
import tsum.site.address.tests.Positive;

@RunWith(Suite.class)
@SuiteClasses({Positive.class, Negative.class})
public class AddressSuite {

    @Steps
    static
    UserSteps user;

    @BeforeClass
    public static void setUp() throws Exception {
        user.openLoginPage();
        user.loginToSite(new UserData("wegavoruxe@easyemail.info", "12345678"));
        user.deleteAllAddresses();

    }

    @AfterClass
    public static void tearDown() throws Exception {

    }

}
