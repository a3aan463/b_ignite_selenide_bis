package b.ignite;

import java.net.MalformedURLException;
import java.net.URL;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	WebDriver driver;
    JavascriptExecutor executor = (JavascriptExecutor) driver;
	//protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        System.out.println("driver" + driver.toString());


    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

	
	@BeforeMethod
    public void setUp() throws MalformedURLException {
        //threadDriver = new ThreadLocal<RemoteWebDriver>();
        //DesiredCapabilities dc =  new DesiredCapabilities("chrome", "28.0", Platform.WINDOWS);
        //threadDriver.set(new RemoteWebDriver(new URL("http://54.215.65.82:4444/wd/hub"), dc));
        //ChromeDriverManager.getInstance().setup();
        //Configuration.browser = "chrome";

    }
 

    //@AfterMethod
    //public void removeThread() {
    //	getDriver().quit();
    //	threadDriver.remove();
    //}
    
    
}
