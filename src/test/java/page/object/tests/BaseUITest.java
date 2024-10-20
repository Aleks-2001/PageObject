package page.object.tests;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.time.Duration;

public class BaseUITest {

    protected WebDriver driver;

    @Before
    public void startUp() {
//        initChrome();
        initSafari();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void initChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--start-maximized", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    public void initSafari() {
        SafariOptions options = new SafariOptions();
        driver = new SafariDriver(options);
    }

}
