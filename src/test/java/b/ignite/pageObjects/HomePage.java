package b.ignite.pageObjects;


import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage {
    public HomePage open() {
        Selenide.open("https://d2r3v7evrrggno.cloudfront.net/");
        return this;
    }

    public void verifyTitle(String title) {
        $(byXpath("//div[@class='title']")).shouldHave(exactText("Test Data Generator language"));
    }

    public void selectBis() {
        $(byXpath("//button[@id='/bis-header-button']")).click();
    }


}
