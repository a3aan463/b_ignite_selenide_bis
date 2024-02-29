package b.ignite;

import com.codeborne.selenide.SelenideElement;
import b.ignite.pageObjects.BisPage;
import b.ignite.pageObjects.HomePage;
import org.testng.annotations.Test;
import resources.Base;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;


public class BisTest_4_clipboard extends BaseTest {
    HomePage home;
    BisPage bis;

    String p_bis_text = "This action returns a Belgian unique identifier for people without the Belgian nationality, but still have a relation with the Belgian government.";

    @Test
    public void BisTest_4_clipboard() throws InterruptedException, IOException, UnsupportedFlavorException {
        //driver = Base.driver;
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


        SelenideElement birthday_yes = $(byXpath("//input[@id='/bis-yes-1']"));
        String birthday_yes_checkedValue = birthday_yes.getAttribute("value");
        boolean birthday_yes_checkedValueBool = Boolean.parseBoolean(birthday_yes_checkedValue);
        SelenideElement birthday_no = $(byXpath("//input[@id='/bis-no-1']"));
        String birthday_no_checkedValue = birthday_no.getAttribute("value");
        boolean birthday_no_checkedValueBool = Boolean.parseBoolean(birthday_no_checkedValue);
        if(birthday) {
            if(birthday_yes_checkedValueBool) {
                bis.enter_date("31121999");
            } else {
                bis.birthday_select_yes();
                bis.enter_date("31121999");
            }
        } else {
            if(birthday_no_checkedValueBool) {
            } else {
                bis.birthday_select_no();
            }
        }

        bis.enter_amount("2");

        Thread.sleep(1000);

        bis.generateBisNumber();
        String bisCode = bis.getBisCode();
        //bis.verifyBisCode(bisCode);
        bis.copyCode();
        String copyTxt = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        //String[] splited = copyTxt.split("(?<=\\G.{" + 11 + "})");
        String[] splited = copyTxt.split("\n");
        System.out.println("splited length: " + splited.length);
        if (splited.length > 1) {
            for (int i = 0; i < splited.length; i++) {
                bis.verifyBisCode(splited[i]);
            }
        } else if (splited.length == 1) {
            bis.verifyBisCode(bisCode);
        }
        //Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        System.out.println("copyTxt:" + copyTxt);
        //Object copyText = c.getData(DataFlavor.stringFlavor);
        assertEquals(bisCode, copyTxt);
    }
}



