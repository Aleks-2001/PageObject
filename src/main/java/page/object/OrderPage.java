package page.object;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;

public class OrderPage {
    protected WebDriver driver;

    private By inputFirstName = By.xpath(".//div[contains(@class, 'InputContainer')]/input[@placeholder = '* Имя']");   // поле для ввода имени
    private By inputSecondName = By.xpath(".//div[contains(@class, 'InputContainer')]/input[@placeholder = '* Фамилия']");   // поле для ввода фамилии
    private By inputAdress = By.xpath(".//div[contains(@class, 'InputContainer')]/input[contains(@placeholder, '* Адрес')]");   // поле для ввода адреса
    private By inputMetroStation = By.xpath(".//div[contains(@class, 'select-search')]/input[contains(@placeholder, 'метро')]");   // поле выбора станции метро
    private By inputTelephoneNumber = By.xpath(".//div[contains(@class, 'InputContainer')]/input[contains(@placeholder, 'елефон')]");   // поле для ввода номера телефона
    private By nextButton= By.xpath(".//div[contains(@class, 'NextButton')]/button[contains(text(), 'алее')]");   // кнопка Далее
    private By deliveryDateInput = By.xpath(".//input[contains(@placeholder, 'Когда привезти')]");   // поле для ввода даты доставки самоката
    private By intervalOfRentActivate = By.xpath(".//span[contains(@class, 'Dropdown-arrow')]");   // поле для выбора срока аренда
    private By intervalOfRentInput = By.xpath(".//div[contains(@class, 'Dropdown-menu')]/div[5]");   // один из элементов в всплывающем меню "срок аренды"
    private By inputColorBlack = By.xpath(".//input[@id = 'black' and contains(@class, 'Checkbox_Input')]");   // элемент для клика - выбор черного цвета
    private By inputColorGray = By.xpath(".//input[@id = 'grey' and contains(@class, 'Checkbox_Input')]");   // элемент для клика - выбор серого цвета
    private By inputComment = By.xpath(".//div[contains(@class, 'InputContainer')]/input[contains(@placeholder, 'омментарий')]");   // поле для комментария
    private By confirmOrderButton = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text() = 'Заказать']");   // кнопка Заказать
    private By confirmOrderButtonYes = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text() = 'Да']");   // кнопка подтверждения заказа "Да"
    private By orserSuccesful = By.xpath(".//*[contains(text(), 'Заказ оформлен')]");   // элемент страницы "Заказ оформлен"

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputValuesInOrderFormOne(String firstName, String secondName, String adress, String telephone) {
        driver.findElement(inputFirstName).clear();
        driver.findElement(inputFirstName).sendKeys(firstName);

        driver.findElement(inputSecondName).clear();
        driver.findElement(inputSecondName).sendKeys(secondName);

        driver.findElement(inputAdress).clear();
        driver.findElement(inputAdress).sendKeys(adress);

        driver.findElement(inputMetroStation).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        driver.findElement(inputTelephoneNumber).clear();
        driver.findElement(inputTelephoneNumber).sendKeys(telephone);
    }

    public void nextButtonClick() {
        driver.findElement(nextButton).click();
    }

    public void inputValuesInOrderFormTwo(String color, String comment){
        driver.findElement(deliveryDateInput).clear();
        String deliveryDate = LocalDate.now().plusDays(2).toString();
        driver.findElement(deliveryDateInput).sendKeys(deliveryDate);
        driver.findElement(deliveryDateInput).sendKeys(Keys.ENTER);

        driver.findElement(intervalOfRentActivate).click();
        driver.findElement(intervalOfRentInput).click();

        if (color.equals("black")) {
            driver.findElement(inputColorBlack).click();
        }   else driver.findElement(inputColorGray).click();

        driver.findElement(inputComment).clear();
        driver.findElement(inputComment).sendKeys(comment);
    }

    public void ConfirmOrderButtonClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }

    public void confirmOrderButtonYesClick() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(confirmOrderButtonYes));
        driver.findElement(confirmOrderButtonYes).click();
    }

    public boolean isDisplayedOrderSuccessful() {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orserSuccesful));
        return driver.findElement(orserSuccesful).isDisplayed();
    }
}
