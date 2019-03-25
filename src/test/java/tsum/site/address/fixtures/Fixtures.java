package tsum.site.address.fixtures;

import net.thucydides.core.annotations.WhenPageOpens;
import org.eclipse.jetty.util.component.Container;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Fixtures {
    //protected final DriverManager app = new DriverManager(BrowserType.FIREFOX);

    @WhenPageOpens
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    /*  @Before
    public void setupProfile() {
        FirefoxProfile myProfile = new FirefoxProfile();
        myProfile.setPreference("network.proxy.socks_port",9999);
        myProfile.setAlwaysLoadNoFocusLib(true);
       // myProfile.setEnableNativeEvents(true);
        Serenity.useFirefoxProfile(myProfile);
    }*/

    /*@BeforeClass*//*(alwaysRun = true)*//*
    public static void setUp() throws Exception {
//        app.init();
    }*/

    /*@AfterClass *//*(alwaysRun = true)*//*
    public void tearDown() throws Exception {
        app.stop();
    }*/

}
