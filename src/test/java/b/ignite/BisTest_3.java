package b.ignite;

import com.codeborne.selenide.SelenideElement;
import b.ignite.pageObjects.BisPage;
import b.ignite.pageObjects.HomePage;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class BisTest_3 extends BaseTest {
    HomePage home;
    BisPage bis;

    String p_bis_text = "This action returns a Belgian unique identifier for people without the Belgian nationality, but still have a relation with the Belgian government.";

    @Test
    public void BisTest_3() throws InterruptedException, IOException {
        //driver = Base.initializeDrvier();
        home = new HomePage();
        bis = new BisPage();
        //Gender Y, Birthday Y, date system, amount 1
        boolean gender = true;
        Boolean birthdayBool = true;
        Integer amount = 1;
        home.open();
        String title = "Test Data Generator language";
        home.verifyTitle(title);
        home.selectBis();
        bis.verifyInfo(p_bis_text);

        bis.enterGender(gender);
        bis.enterBirthday(birthdayBool, "31101961");

        bis.enter_amount("1");

        Thread.sleep(1000);

        bis.generateBisNumber();
        String bisCode = bis.getBisCode();
        bis.verifyBisCodeMonthOfBirthGenderYes(bisCode, 50);
        bis.verifyBisCode(bisCode);

        }
}



