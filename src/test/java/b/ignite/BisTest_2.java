package b.ignite;

import com.codeborne.selenide.SelenideElement;
import b.ignite.pageObjects.BisPage;
import b.ignite.pageObjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;



public class BisTest_2 extends BaseTest {
    HomePage home;
    BisPage bis;

    String p_bis_text = "This action returns a Belgian unique identifier for people without the Belgian nationality, but still have a relation with the Belgian government.";

    @Test
    public void BisTest_2() throws InterruptedException, IOException {
        //driver = Base.initializeDrvier();
        home = new HomePage();
        bis = new BisPage();
        //Gender Y, Birthday Y, date system, amount 1
        boolean gender = false;
        Boolean birthdayBool = false;
        Integer amount = 1;
        home.open();
        String title = "Test Data Generator language";
        home.verifyTitle(title);
        home.selectBis();
        bis.verifyInfo(p_bis_text);

        bis.enterGender(gender);

        bis.enterBirthday(birthdayBool);

        bis.enter_amount("1");

        bis.generateBisNumber();
        String bisCode = bis.getBisCode();
        bis.verifyBisCodeMonthOfBirthGenderNo(bisCode);
        bis.verifyBisCode(bisCode);

        }
}



