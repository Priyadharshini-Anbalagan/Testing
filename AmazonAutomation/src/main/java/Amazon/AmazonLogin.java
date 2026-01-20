package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonLogin {
	public static void main(String[] args) {
	      
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        Actions actions = new Actions(driver);
        WebElement singleClick = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.click(singleClick).perform();
        driver.findElement(By.id("ap_email_login")).sendKeys("priyadharshinia67@gmail.com");
        WebElement clickElement = driver.findElement(By.xpath("//input[@type='submit']"));
        actions.click(clickElement).perform();
        
        WebElement clickElement2 = driver.findElement(By.xpath("//input[@class='a-button-input']"));
        actions.click(clickElement2).perform();
        driver.findElement(By.id("ap_phone_number")).sendKeys("9791917888");
        driver.findElement(By.id("ap_customer_name")).sendKeys("Priyadharshini");
        driver.findElement(By.id("ap_password")).sendKeys("Priyadharshini@12345");
        WebElement clickElement3 = driver.findElement(By.id("continue"));
        actions.click(clickElement3).perform();
        driver.quit();
}
}
