package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilitiesLibrary.Driver;

public class Guru99PaymentGatewayConfirmationPage {

    public Guru99PaymentGatewayConfirmationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//h2[.='Payment successfull!']")
    private WebElement successfulMessage;

    public void messageVerification (String expectedMessage) {
        Assert.assertEquals("Message verification failed",
                expectedMessage,successfulMessage.getText());
    }
}
