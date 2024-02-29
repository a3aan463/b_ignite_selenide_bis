package b.ignite.pageObjects;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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

    public void verifyBisCodeMonthOfBirthGenderNo(String bisCode) {
        System.out.println("bisCode: " + bisCode );

        String monthStr = bisCode.substring(2, 4);
        System.out.println("code: " + monthStr );
        int codeInt = Integer.parseInt(monthStr);
        assertEquals(codeInt, 20);

    }

    public void verifyBisCodeMonthOfBirthGenderYes(String bisCode, int expectedValue) {
        System.out.println("bisCode: " + bisCode );

        String monthStr = bisCode.substring(2, 4);
        System.out.println("code: " + monthStr );
        int codeInt = Integer.parseInt(monthStr);
        assertEquals(codeInt, expectedValue);

    }

    public  void generateBisNumber() throws InterruptedException {
        $(byXpath("//button[@id='/bis-generate-button']")).scrollIntoView(true);
        Thread.sleep(500);
        if ($(byXpath("//button[@id='/bis-generate-button']")).scrollIntoView(true).isEnabled()) {
            $(byXpath("//button[@id='/bis-generate-button']")).click();
        }
    }

    public void enterGender(boolean gender) {
        SelenideElement gender_yes = $(byXpath("//input[@id='/bis-yes-0']"));
        String gender_yes_checkedValue = gender_yes.getAttribute("value");
        boolean gender_yes_checkedValueBool = Boolean.parseBoolean(gender_yes_checkedValue);
        SelenideElement gender_no = $(byXpath("//input[@id='/bis-no-0']"));
        String gender_no_checkedValue = gender_no.getAttribute("value");
        boolean gender_no_checkedValueBool = Boolean.parseBoolean(gender_no_checkedValue);
        if(gender) {
            if(gender_yes_checkedValueBool) {

            } else {
                gender_select_yes();
            }
        } else {
            if(gender_no_checkedValueBool) {

            } else {
                gender_select_no();
            }
        }
    }

    public void enterBirthday(Boolean birthdayBool, String birthdayDate) {
        SelenideElement birthday_yes = $(byXpath("//input[@id='/bis-yes-1']"));
        String birthday_yes_checkedValue = birthday_yes.getAttribute("value");
        boolean birthday_yes_checkedValueBool = Boolean.parseBoolean(birthday_yes_checkedValue);
        SelenideElement birthday_no = $(byXpath("//input[@id='/bis-no-1']"));
        String birthday_no_checkedValue = birthday_no.getAttribute("value");
        boolean birthday_no_checkedValueBool = Boolean.parseBoolean(birthday_no_checkedValue);
        if(birthdayBool) {
            if(birthday_yes_checkedValueBool) {
                enter_date(birthdayDate);
            } else {
                birthday_select_yes();
                enter_date(birthdayDate);
            }
        } else {
            if(birthday_no_checkedValueBool) {
            } else {
                birthday_select_no();
            }
        }
    }

    public void enterBirthday(Boolean birthdayBool) {
        SelenideElement birthday_no = $(byXpath("//input[@id='/bis-no-1']"));
        String birthday_no_checkedValue = birthday_no.getAttribute("value");
        boolean birthday_no_checkedValueBool = Boolean.parseBoolean(birthday_no_checkedValue);
        if(birthdayBool) {

        } else {
            if(birthday_no_checkedValueBool) {
            } else {
                birthday_select_no();
            }
        }
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
        String bisCode = $(byXpath("//pre[@id='bis-text']")).scrollIntoView(true).getText();
        return bisCode;
    }
}
