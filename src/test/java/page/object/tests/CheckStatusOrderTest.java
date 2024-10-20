package page.object.tests;
import org.junit.Assert;
import org.junit.Test;
import page.object.MainPage;
import page.object.TrackPage;

public class CheckStatusOrderTest extends BaseUITest {

    @Test
    public void checkOrderStatusNotExistTest() {      // тест для проверки статуса заказа
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.cookieButtonConfirmClick();
        mainPage.statusOrderButtonClick();
        mainPage.orderNumberSendKeys("a4635426");
        mainPage.goButtonClick();
        TrackPage trackPage = new TrackPage(driver);
        boolean isDisplayedNotFoundOrderImg = trackPage.isDisplayedNotFoundOrderImg();
        Assert.assertTrue(isDisplayedNotFoundOrderImg);
    }
}