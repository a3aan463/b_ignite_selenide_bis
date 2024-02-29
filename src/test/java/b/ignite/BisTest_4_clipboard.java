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
        boolean gender = true;
        Boolean birthdayBool = true;
        Integer amount = 1;
        home.open();
        String title = "Test Data Generator language";
        home.verifyTitle(title);
        home.selectBis();
        bis.verifyInfo(p_bis_text);

        bis.enterGender(gender);
        bis.enterBirthday(birthdayBool, "31121999");
        bis.enter_amount("2");

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



