package b.ignite;

import com.codeborne.selenide.SelenideElement;
import b.ignite.pageObjects.BisPage;
import b.ignite.pageObjects.HomePage;
import org.testng.annotations.Test;
import resources.Base;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BisTest extends BaseTest {
    HomePage home;
    BisPage bis;

    String p_bis_text = "This action returns a Belgian unique identifier for people without the Belgian nationality, but still have a relation with the Belgian government.";

    @Test
    public void BisTest_1() throws InterruptedException {
        home = new HomePage();
        bis = new BisPage();
        //Gender Y, Birthday Y, date system, amount 1
        boolean gender = true;
        boolean birthdayBool = true;
        Integer amount = 1;

        home.open();
        String title = "Test Data Generator language";
        home.verifyTitle(title);
        home.selectBis();
        bis.verifyInfo(p_bis_text);

        bis.enterGender(gender);
        bis.enterBirthday(birthdayBool);

        bis.enter_date("27022024");

        bis.enter_amount("1");

        Thread.sleep(1000);

        bis.generateBisNumber();
        String bisCode = bis.getBisCode();
        bis.verifyBisCode(bisCode);

        }
}



