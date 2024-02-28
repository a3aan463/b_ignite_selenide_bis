package b.ignite;

import com.codeborne.selenide.SelenideElement;
import b.ignite.pageObjects.BisPage;
import b.ignite.pageObjects.HomePage;
import org.testng.annotations.Test;
import resources.Base;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class BisTest extends Base {
    HomePage home;
    BisPage bis;

    String p_bis_text = "This action returns a Belgian unique identifier for people without the Belgian nationality, but still have a relation with the Belgian government.";

    @Test
    public void BisTest_1() throws InterruptedException {
        driver = Base.driver;
        home = new HomePage();
        bis = new BisPage();
        //Gender Y, Birthday Y, date system, amount 1
        Boolean gender = true;
        Boolean birthday = true;
        Integer amount = 1;
        home.open();
        String title = "Test Data Generator language";
        home.verifyTitle(title);
        home.selectBis();
        bis.verifyInfo(p_bis_text);

        SelenideElement gender_yes = $(byXpath("//input[@id='/bis-yes-0']"));
        SelenideElement gender_no = $(byXpath("//input[@id='/bis-no-0']"));
        if(gender) {
            if(gender_yes.isSelected()) {

            } else {
                bis.gender_select_yes();
            }
        } else {
            if(gender_no.isSelected()) {

            } else {
                bis.gender_select_no();
            }
        }


        SelenideElement birthday_yes = $(byXpath("//input[@id='/bis-yes-1']"));
        SelenideElement birthday_no = $(byXpath("//input[@id='/bis-yes-1']"));
        if(birthday) {
            if(birthday_yes.isSelected()) {
            } else {
                bis.birthday_select_yes();
            }
        } else {
            if(birthday_no.isSelected()) {
            } else {
                bis.birthday_select_no();
            }
        }


        bis.enter_date("27022024");

        bis.enter_amount("1");

        Thread.sleep(5000);

        if($(byXpath("//button[@id='/bis-generate-button']")).isEnabled()) {
            $(byXpath("//button[@id='/bis-generate-button']")).click();
        }
        String bisCode = bis.getBisCode();
        bis.verifyBisCode(bisCode);

        }
}



