package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Guru99PaymentGatewayConfirmationPage;
import pages.Guru99PaymentGatewayOrderPage;
import pages.Guru99PaymentGatewayPaymentPage;
import utilitiesLibrary.BrowserUtils;
import utilitiesLibrary.ConfigurationReader;
import utilitiesLibrary.Driver;

import java.util.Map;

public class Guru99PaymentGateway extends BrowserUtils {
    Guru99PaymentGatewayOrderPage orderPage = new Guru99PaymentGatewayOrderPage();
    Guru99PaymentGatewayPaymentPage paymentPage = new Guru99PaymentGatewayPaymentPage();
    Guru99PaymentGatewayConfirmationPage confirmationPage = new Guru99PaymentGatewayConfirmationPage();

    @Given("the user wants to visit Guru99 order page")
    public void the_user_wants_to_visit_guru99_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("Guru99PaymentGateway"));
    }

    @When("the user wants to check that URL contain {string}")
    public void the_user_wants_to_check_that_url_contain(String expectedPartUrl) {
        orderPage.urlVerification(expectedPartUrl);
    }

    @Then("the user wants to verify {string} header")
    public void the_user_wants_to_verify_header(String expectedHeader) {
        orderPage.headerVerification(expectedHeader);
    }

    @Then("the user wants to verify that the toy price is {string}")
    public void the_user_wants_to_verify_that_the_toy_price_is(String expectedPrice) {
        orderPage.priceVerification(expectedPrice);
    }

    @Then("the user wants to choose {string} units of the product")
    public void the_user_wants_to_choose_units_of_the_product(String quantity) {
        orderPage.selectQuantity(quantity);
    }

    @Then("the user wants to click on buy button")
    public void the_user_wants_to_click_on_buy_button() {
        orderPage.clickBuyNow();
    }

    @Then("The user wants to enter payment data as follows")
    public void the_user_wants_to_enter_payment_data_as_follows(Map<String, String> dataTable) {
        paymentPage.setCardNumberBox(dataTable.get("Card Number"));
        paymentPage.setExpirationMonthDropdown(dataTable.get("Expiration Month"));
        paymentPage.setExpirationYearDropdown(dataTable.get("Expiration Year"));
        paymentPage.setCvvCodeBox(dataTable.get("CVV Code"));
    }

    @Then("the user wants to click on pay now button")
    public void the_user_wants_to_click_on_pay_now_button() {
        paymentPage.clickBuyButton();
    }

    @Then("the user wants to verify a {string} message")
    public void the_user_wants_to_verify_a_message(String expectedMessage) {
        confirmationPage.messageVerification(expectedMessage);
    }
    @Then("the user wants to choose certain {string} of the product")
    public void the_user_wants_to_choose_certain_of_the_product(String quantity) {
        orderPage.selectQuantity(quantity);
    }

}
