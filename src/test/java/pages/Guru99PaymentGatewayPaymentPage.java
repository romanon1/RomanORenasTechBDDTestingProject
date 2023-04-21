package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitiesLibrary.BrowserUtils;
import utilitiesLibrary.Driver;

public class Guru99PaymentGatewayPaymentPage extends BrowserUtils {
    public Guru99PaymentGatewayPaymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='card_nmuber']")
    private WebElement cardNumberBox;
    @FindBy(xpath = "//select[@id='month']")
    private WebElement expirationMonthDropdown;
    @FindBy(xpath = "//select[@id='year']")
    private WebElement expirationYearDropdown;
    @FindBy(xpath = "//input[@id='cvv_code']")
    private WebElement cvvCodeBox;
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement buyButton;

    public void setCardNumberBox(String cardNumber) {
        cardNumberBox.sendKeys(cardNumber);
    }

    public void setExpirationMonthDropdown(String month) {
        selectFromDropdown(expirationMonthDropdown, month);
    }

    public void setExpirationYearDropdown(String year) {
        selectFromDropdown(expirationYearDropdown, year);
    }

    public void setCvvCodeBox(String cvvCode) {
        cvvCodeBox.sendKeys(cvvCode);
    }

    public void clickBuyButton() {
        clickWithWait(buyButton);
    }
}
