import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import simulation.MainPage;

/**
 * Created by Andrii Shershnov on 11.09.2016.
 */
public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPageObj;

    @BeforeSuite
    @Parameters({"test-platform-uri","browser"})
    public void start(@Optional("localhost:8080")String testUri, @Optional("IE")String browser){
        initDriver(browser);
        mainPageObj = new MainPage(driver);
        loadURI(testUri);
    }

    private void initDriver(String browser){
        if(browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", "SeleniumBrowserDrivers\\IEDriverServer_32.exe");
            driver = new InternetExplorerDriver();
        }if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","SeleniumBrowserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }

    protected void loadURI(String uri){
        driver.get(uri);
        driver.manage().window().maximize();
    }
}
