package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitiesLibrary.BrowserUtils;
import utilitiesLibrary.Driver;

public class Guru99PaymentGatewayOrderPage extends BrowserUtils {

    public Guru99PaymentGatewayOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[.='Mother Elephant With Babies Soft Toy']")
    private WebElement productHeader;

    @FindBy(xpath = "//h3[.='Price: $20']")
    private WebElement priceHeader;

    @FindBy(xpath = "//select[@name='quantity']")
    private WebElement quantityDropdown;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buyNowButton;


    public void urlVerification(String expectedPartUrl) {
        setWaitTime();
        Assert.assertTrue("Url verification failed",
                Driver.getDriver().getCurrentUrl().contains(expectedPartUrl));
    }

    public void headerVerification(String expectedHeader) {
        setWaitTime();
        Assert.assertEquals("Header verification failed",
                expectedHeader, productHeader.getText());
    }

    public void priceVerification(String expectedPrice) {
        setWaitTime();
        Assert.assertTrue("Url verification failed",
                priceHeader.getText().contains(expectedPrice));
    }

    public void selectQuantity (String quantity) {
        setWaitTime();
        selectFromDropdown(quantityDropdown,quantity);
    }

    public void clickBuyNow() {
        setWaitTime();
        clickWithWait(buyNowButton);
    }


}
