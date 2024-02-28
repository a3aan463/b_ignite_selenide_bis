package b.ignite;

import com.codeborne.selenide.SelenideElement;
import b.ignite.pageObjects.BisPage;
import b.ignite.pageObjects.HomePage;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class BisTest_3 extends Base {
    HomePage home;
    BisPage bis;

    String p_bis_text = "This action returns a Belgian unique identifier for people without the Belgian nationality, but still have a relation with the Belgian government.";

    @Test
    public void BisTest_3() throws InterruptedException, IOException {
        //driver = Base.initializeDrvier();
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
        SelenideElement birthday_no = $(byXpath("//input[@id='/bis-no-1']"));
        if(birthday) {
            if(birthday_yes.isSelected()) {
            } else {
                bis.birthday_select_yes();
                bis.enter_date("31101961");
            }
        } else {
            if(birthday_no.isSelected()) {
            } else {
                bis.birthday_select_no();
            }
        }


        //bis.enter_date("27022024");

        bis.enter_amount("1");

        Thread.sleep(1000);

        //$(byXpath("//button[@id='/bsn-header-button']")).scrollIntoView(true);
        $(byXpath("//button[@id='/bis-generate-button']")).scrollIntoView(true);
        Thread.sleep(500);
        if($(byXpath("//button[@id='/bis-generate-button']")).scrollIntoView(true).isEnabled()) {
            $(byXpath("//button[@id='/bis-generate-button']")).click();
        }
        String bisCode = bis.getBisCode();
        bis.verifyBisCodeMonthOfBirthGenderYes(bisCode);
        bis.verifyBisCode(bisCode);

        }
}



