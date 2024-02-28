package b.ignite.pageObjects;


import com.codeborne.selenide.Selenide;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class BisPage {

    public void verifyBisCode(String bisCode) {
        //String bisCode = bis.getBisCode();
        System.out.println("bisCode: " + bisCode );
        String code = bisCode.substring(0, 9);
        System.out.println("code: " + code );
        int codeInt = Integer.parseInt(code);
        int rest = codeInt % 97;
        System.out.println("rest: " + rest );
        int controlNr = 97 - rest;

        System.out.println("controlNr: " + controlNr );
        String controlNumber = bisCode.substring(9, 11);
        System.out.println("controlNumber: " + controlNumber );
        Integer controlNumberInt = Integer.parseInt(controlNumber);
        assertEquals(controlNumberInt, controlNr);

    }

    public void verifyInfo(String info) {
        $(byXpath("(//div[@aria-labelledby='tab-/bis']//p)[1]")).shouldHave(exactText(info));
    }

    public void gender_select_yes() {
        $(byXpath("//input[@id='/bis-yes-0']")).click();
    }
    public void gender_select_no() {
        $(byXpath("//input[@id='/bis-no-0']")).click();
    }

    public void birthday_select_yes() {
        $(byXpath("//input[@id='/bis-yes-1']")).click();
    }
    public void birthday_select_no() {
        $(byXpath("//input[@id='/bis-no-1']")).click();
    }

    public void enter_date(String date) {
        $(byXpath("//input[@id='/bis-2']")).sendKeys(date);
    }

    public void copyCode() {
        $(byXpath("//button[@class='btn btn-copy']")).click();
    }

    public void enter_amount(String amount) {
        $(byXpath("//input[@id='/bis-3']")).sendKeys(amount);
    }

    public String getBisCode() {
        String bisCode = $(byXpath("//pre[@id='bis-text']")).getText();
        return bisCode;
    }
}
