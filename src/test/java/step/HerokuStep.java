package step;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class HerokuStep {
    private final SelenideElement inputNameField = $x("//*[@id=\"username\"]");
    private final  SelenideElement inputPasswordField = $x("/html/body/div[2]/div/div/form/div[2]/div/input");
    private final SelenideElement loginButton = $x("/html/body/div[2]/div/div/form/button");
    private final SelenideElement successMessage = $x("//div[contains(text(), 'You logged into a secure area!')]");
    private final SelenideElement invalidMessage = $x("//div[contains(text(), 'Your username is invalid!')]");

    @When("I enter my {string} on the Login page")
    public void enterUserName(String name){
        inputNameField.sendKeys(name);
    }

    @When("I enter my {string} username and invalid {string} password on the Login page")
    public void unSuccessPass(String userName, String pass){
        inputNameField.sendKeys(userName);
        inputPasswordField.sendKeys(pass);
    }

    @And("I enter my valid {string} to the Login page")
    public void enterPassword(String password){
        inputPasswordField.sendKeys(password);
    }

    @And("I click on Login button on the Login page")
    public void submitButton(){
        loginButton.click();
    }

    @Then("I should successfully logged to the Login page")
    public void successLogin(){
        Assertions.assertTrue(successMessage.isDisplayed());
    }

    @Then("I shouldn't successfully logged to the Login page")
    public void unSuccessLogin(){
        Assertions.assertTrue(invalidMessage.isDisplayed());
    }
}
