package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackPage {
    protected WebDriver driver;

    private By notFoundOrderImg = By.xpath(".//div[contains(@class, 'NotFound')]/img");

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayedNotFoundOrderImg(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(notFoundOrderImg));
        return driver.findElement(notFoundOrderImg).isDisplayed();
    }
}
