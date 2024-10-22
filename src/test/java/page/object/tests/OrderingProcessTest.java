package page.object.tests;
import org.junit.Assert;
import org.junit.Test;
import page.object.MainPage;
import page.object.OrderPage;

public class OrderingProcessTest extends BaseUITest{

    @Test
    public void firstValuesOrderingProcessTest() {       // тест для проверки всего пути оформления заказа (первый набор данных)
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.cookieButtonConfirmClick();
        mainPage.OrderButtonUpperClick();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputValuesInOrderFormOne("Алексей", "Петров", "Комсомольская, дом 34",  "+79215672121");
        orderPage.nextButtonClick();
        orderPage.inputValuesInOrderFormTwo("black","заплачу чаевые");
        orderPage.ConfirmOrderButtonClick();
        orderPage.confirmOrderButtonYesClick();
        boolean isDisplayedOrderSuccessful = orderPage.isDisplayedOrderSuccessful();
        Assert.assertTrue(isDisplayedOrderSuccessful);
    }
    @Test
    public void secondValuesOrderingProcessTest() {      // тест для проверки всего пути оформления заказа (второй набор данных)
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.cookieButtonConfirmClick();
        mainPage.OrderButtonLowerClick();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.inputValuesInOrderFormOne("Иоган Себастьян", "Бах", "Красная Площадь дом 1",  "49215672121");
        orderPage.nextButtonClick();
        orderPage.inputValuesInOrderFormTwo("gray","без комментариев");
        orderPage.ConfirmOrderButtonClick();
        orderPage.confirmOrderButtonYesClick();
        boolean isDisplayedOrderSuccessful = orderPage.isDisplayedOrderSuccessful();
        Assert.assertTrue(isDisplayedOrderSuccessful);
    }

}
