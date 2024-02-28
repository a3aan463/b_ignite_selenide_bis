package b.ignite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Feature1 extends BaseTest{


	@Test
	public void test1 ()
	{
        WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		WebElement textBox = driver.findElement(By.cssSelector("input#gbqfq"));
        textBox.click();
        textBox.sendKeys("Test 1!");
        
	}
	
	@Test
    public void test3(){
        driver.get("http://facebook.com");
        WebElement textBox = driver.findElement(By.xpath("//input[@value='Re-enter Email']"));
        textBox.click();
        textBox.sendKeys("Test 3!");
        
    }
	
}
