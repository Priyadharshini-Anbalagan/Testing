package Amazon.AddtoCart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
	@Test(priority = 1)
    public void viewEmptyCart() {
		 driver.get("https://www.amazon.in/");
	     WebElement cartBtn = driver.findElement(By.id("nav-cart"));
	     new Actions(driver).click(cartBtn).perform();
	     System.out.println("Cart is Empty");
	     
    }

    @Test(priority = 2)
    public void incQuantityToCart() {
        driver.get("https://www.amazon.in/");
        WaitUtils.waitForSeconds(3);
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Toys under age 2");
        driver.findElement(By.id("nav-search-submit-button")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0.6)");
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@name='submit.addToCart']"));
        addToCartBtn.click();
        System.out.println("product 1 addeded");
        WebElement increaseQty = WaitUtils.waitUntilClickable(driver, 
        By.xpath("//button[contains(@aria-label, 'Increase quantity')]"), 10);
        increaseQty.click();
        System.out.println("product 1 - item 2 addeded");
    }

    @Test(priority = 3)
    public void addSingleProductToCart() {
    		driver.get("https://www.amazon.in/");
        WaitUtils.waitForSeconds(3);
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Laptop under 40k");
        driver.findElement(By.id("nav-search-submit-button")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0.6)");
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@name='submit.addToCart']"));
        addToCartBtn.click();
        System.out.println("product 2 - item 3 addeded");
    }

    @Test(priority = 4)
    public void addMultipleProductToCart() {
    	driver.get("https://www.amazon.in/");
        WaitUtils.waitForSeconds(3);
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Vivo mobiles under 30k");
        driver.findElement(By.id("nav-search-submit-button")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0.2)");
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@name='submit.addToCart']"));
        addToCartBtn.click();
        System.out.println("product 3 - item 4 addeded");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8, 700));
        js.executeScript("window.scrollBy(0.0,0.4)");
        WebElement add2 = driver.findElement(By.xpath("//button[@id='a-autoid-5-announce']"));
        //actions.scrollToElement(add2).click().perform();
        add2.click();
        System.out.println("product 3 - item 5 addeded");
        
        js.executeScript("window.scrollBy(0.0,0.6)");
        WebElement add3 = driver.findElement(By.xpath("//button[@id='a-autoid-9-announce']"));
        //actions.scrollToElement(add3).click().perform();
        add3.click();
        System.out.println("product 3 - item 6 addeded");
    }

    @Test(priority = 5)
    public void viewCart() {
        driver.get("https://www.amazon.in/");
        WebElement cartBtn = driver.findElement(By.id("nav-cart"));
        new Actions(driver).click(cartBtn).perform();

        WebElement increaseQty = WaitUtils.waitUntilClickable(driver,
                By.xpath("//button[contains(@aria-label, 'Increase quantity')]"), 10);
        increaseQty.click();
        System.out.println("item 7 addeded");
    }
    @Test(priority = 6)
    public void deleteProduct() {
        driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
        WaitUtils.waitForSeconds(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0.6)");
        WebElement addToCartBtn = driver.findElement(By.xpath("//input[@value='Delete']"));
        addToCartBtn.click();
        System.out.println("item 1 deleted");
    }

    @Test(priority = 7)
    public void proceedToPay() {
        driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");

        WebElement checkoutBtn = WaitUtils.waitUntilClickable(driver, By.name("proceedToRetailCheckout"), 10);
        checkoutBtn.click();

        WebElement emailInput = WaitUtils.waitUntilVisible(driver, By.id("ap_email_login"), 10);
        emailInput.sendKeys("priyadharshinia67@gmail.com");

        WebElement continueBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        new Actions(driver).click(continueBtn).perform();
    }
}
