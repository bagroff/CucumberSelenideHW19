package step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("I open Login page {string}")
    public void openLoginPage(String url){
        Selenide.open(url);
    }
}
