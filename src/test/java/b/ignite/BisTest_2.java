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



public class BisTest_2 extends Base {
    HomePage home;
    BisPage bis;

    String p_bis_text = "This action returns a Belgian unique identifier for people without the Belgian nationality, but still have a relation with the Belgian government.";

    @Test
    public void BisTest_2() throws InterruptedException, IOException {
        //driver = Base.initializeDrvier();
        home = new HomePage();
        bis = new BisPage();
        //Gender Y, Birthday Y, date system, amount 1
        Boolean gender = false;
        Boolean birthday = false;
        Integer amount = 1;
        home.open();
        String title = "Test Data Generator language";
        home.verifyTitle(title);
        home.selectBis();
        bis.verifyInfo(p_bis_text);

        SelenideElement gender_yes = $(byXpath("//input[@id='/bis-yes-0']"));
        String gender_yes_checkedValue = gender_yes.getAttribute("value");
        boolean gender_yes_checkedValueBool = Boolean.parseBoolean(gender_yes_checkedValue);
        SelenideElement gender_no = $(byXpath("//input[@id='/bis-no-0']"));
        String gender_no_checkedValue = gender_no.getAttribute("value");
        boolean gender_no_checkedValueBool = Boolean.parseBoolean(gender_no_checkedValue);
        if(gender) {
            if(gender_yes_checkedValueBool) {

            } else {
                bis.gender_select_yes();
            }
        } else {
            if(gender_no_checkedValueBool) {

            } else {
                bis.gender_select_no();
            }
        }

        Thread.sleep(1000);
        SelenideElement birthday_yes = $(byXpath("//input[@id='/bis-yes-1']"));
        String birthday_yes_checkedValue = birthday_yes.getAttribute("value");
        boolean birthday_yes_checkedValueBool = Boolean.parseBoolean(birthday_yes_checkedValue);
        SelenideElement birthday_no = $(byXpath("//input[@id='/bis-no-1']"));
        String birthday_no_checkedValue = birthday_no.getAttribute("value");
        boolean birthday_no_checkedValueBool = Boolean.parseBoolean(birthday_no_checkedValue);
        if(birthday) {
            if(birthday_yes_checkedValueBool) {
                bis.enter_date("27022024");
            } else {
                bis.birthday_select_yes();
                bis.enter_date("27022024");
            }
        } else {
            if(birthday_no_checkedValueBool) {
            } else {
                bis.birthday_select_no();
            }
        }



        //bis.enter_date("27022024");

        bis.enter_amount("1");

        Thread.sleep(1000);

        bis.generateBisNumber();
        String bisCode = bis.getBisCode();
        bis.verifyBisCodeMonthOfBirthGenderNo(bisCode);
        bis.verifyBisCode(bisCode);

        }
}



