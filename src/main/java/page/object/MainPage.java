package page.object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    protected WebDriver driver;


    private By cookieButtonConfirm = By.xpath(".//*[@id='rcc-confirm-button']");  // кнопка подтверждения согласия с куки
    private By orderButtonUpper = By.xpath(".//div[contains(@class, 'Header_Nav')]/button[text() = 'Заказать']");  // кнопка "заказ" в верхней части страницы
    private By orderButtonLower = By.xpath(".//div[contains(@class, 'Home_Finish')]/button[text() = 'Заказать']");  // кнопка "заказ" в нижней части страницы
    private By statusOrderButton = By.xpath(".//button[contains(@class, 'Header_Link')]");  // кнопка проверки статуса заказа
    private By orderNumberInput = By.xpath(".//input[@type = 'text']");  //  поле для ввода номера заказа
    private By goButton = By.xpath(".//button[contains(@class, 'Header_Button') and text() = 'Go!']");  // кнопка Go
    public static String Main_Page_URL = "https://qa-scooter.praktikum-services.ru";  // адрес главной страницы
    public static final String FAQ_QUESTION_PATTERN = ".//div[contains(@id, 'accordion__heading') and text() = '%s']";   // паттерн вопроса в FAQ для создания локатора поиска
    public static final String FAQ_ANSWER_PATTERN = ".//div[contains(@class, 'accordion__panel') and not (@hidden)]/p";  // паттерн ответа в FAQ

    public  MainPage (WebDriver driver){
        this.driver = driver;
    }

    public void openMainPage(){
        driver.get(Main_Page_URL);
    }

    public void statusOrderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(statusOrderButton));
        driver.findElement(statusOrderButton).click();
    }

    public void orderNumberSendKeys(String orderNumber){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput));
        driver.findElement(orderNumberInput).clear();
        driver.findElement(orderNumberInput).sendKeys(orderNumber);
    }

    public void goButtonClick(){
        driver.findElement(goButton).click();
    }

    public void cookieButtonConfirmClick() {
        driver.findElement(cookieButtonConfirm).click();
    }

    public void OrderButtonUpperClick() {
        driver.findElement(orderButtonUpper).click();
    }

    public void OrderButtonLowerClick() {
        driver.findElement(orderButtonLower).click();
    }

    public String clickQuestionCheckAnswer (String questionMessage) {
        String questionLocator = String.format(FAQ_QUESTION_PATTERN, questionMessage);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(questionLocator)));
        WebElement element = driver.findElement(By.xpath(questionLocator)); element.sendKeys(Keys.DOWN);
        driver.findElement(By.xpath(questionLocator)).click();
        return driver.findElement(By.xpath(FAQ_ANSWER_PATTERN)).getText();

    }

}
