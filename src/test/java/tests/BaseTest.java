package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.StorePage;

public class BaseTest {
    private WebDriver driver;
    private ChromeOptions options;
    protected StorePage storePage;

    @BeforeTest
    public void setDriver(){
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.com/");

        storePage = PageFactory.initElements(driver, StorePage.class);
    }

    @BeforeSuite
    public void setupChromeDriver() {
        WebDriverManager.chromedriver().browserVersion("91.0.4472.101").setup();
        options = new ChromeOptions();
        options.addArguments("start-maximized");
    }

    @AfterTest
    public void closeUp() {
        driver.close();
    }
}