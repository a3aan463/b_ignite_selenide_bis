package b.ignite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class Feature2 extends BaseTest{

	@Test
	public void test2 ()
	{
		driver.get("http://www.google.com");
		WebElement textBox = driver.findElement(By.cssSelector("input#gbqfq"));
        textBox.click();
        textBox.sendKeys("Test 2!");
        
	}
	
	@Test
    public void test4(){
        driver.get("http://www.facebook.com");
        WebElement textBox = driver.findElement(By.xpath("//input[@value='Re-enter Email']"));
        textBox.click();
        textBox.sendKeys("Test 4!");
        
    }
	
	
}
