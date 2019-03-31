package tsum.site.address.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import tsum.site.address.pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

//import static org.testng.Assert.fail;

public class DriverManager {
    private WebDriver driver;
    private String browser;
    private LoginPage loginPage;
    private StringBuffer verificationErrors = new StringBuffer();

    public DriverManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "C:/Utility/BrowserDrivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", "C:/Utility/BrowserDrivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equals(BrowserType.IE)) {
            System.setProperty("webdriver.ie.driver", "C:/Utility/BrowserDrivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
       // loginPage = new LoginPage(driver);
        //loginPage.login();
    }


    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
    public void gotoLoginPage() {
        gotoLoginPage();
    }

}
