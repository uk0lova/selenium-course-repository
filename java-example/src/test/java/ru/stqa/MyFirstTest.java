package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyFirstTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {

        //driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        //driver = new EdgeDriver();

        //work with Capabilities in IE
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        driver = new InternetExplorerDriver(caps); // InternetExplorerDriver(caps);*/
        //System.out.println(((HasCapabilities)driver).getCapabilities());

        /*
        //work with ChromeOptions (chromium-command-line-switches)
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        //path to the executable file
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        //headless mode
        options.setHeadless(true);
        //work with preferences (user settings)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);*/

        //work with Capabilities in Chrome
        /*DesiredCapabilities caps = new DesiredCapabilities();
        //wrapping options to capabilities
        //caps.setCapability(ChromeOptions.CAPABILITY,options);

        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        driver = new ChromeDriver(caps);*/
        //System.out.println(((HasCapabilities) driver).getCapabilities());

        //old schema for selenium<v.3.3
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        caps.setCapability("firefox_binary","C:\\Program Files\\Mozilla Firefox ESR\\firefox.exe");
        driver = new FirefoxDriver(caps);
        System.out.println(((HasCapabilities) driver).getCapabilities());*/

        //new schema for selenium>v.3.3
        /*FirefoxOptions options = new FirefoxOptions().setLegacy(true);
        options.setBinary("C:\\Program Files\\Mozilla Firefox ESR\\firefox.exe");
        driver = new FirefoxDriver(options);*/
        wait = new WebDriverWait(driver, 10);

      }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }
}
