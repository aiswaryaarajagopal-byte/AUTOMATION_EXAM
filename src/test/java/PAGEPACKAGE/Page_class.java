package PAGEPACKAGE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_class {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	// Login Email
	@FindBy(id="CustomerEmail")
	WebElement email;

	// Login Password
	@FindBy(id="CustomerPassword")
	WebElement password;

	// Login Button
	@FindBy(xpath="//*[@id=\"customer_login\"]/div/div[3]/input")
	WebElement loginBtn;

	// Collections Menu
	@FindBy(xpath="//*[@id=\"velaMegamenu\"]/nav/ul/li[1]/a[1]/span")
	WebElement collections;

	// First Product Add To Cart Button
	@FindBy(xpath="//*[@id=\"8237572587574\"]/div[1]/div[2]/div/div/div[2]/button")
	WebElement firstProductAddCart;

	
	
	public Page_class(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		js=(JavascriptExecutor)driver;
	}

	
	public void login(String user,String pass)
	{
		driver.get("https://www.houseofem5.com/account/login");

		email.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
	}

	// Hover on collections and select first option
	public void hoverCollectionAndSelectFirst()
	{
		Actions act = new Actions(driver);

		act.moveToElement(collections).perform();

		WebElement firstOption = driver.findElement(By.xpath("//*[@id=\"megaDropdown21\"]/div/div/div/div/div/div[1]/div/div/div/a"));

		act.moveToElement(firstOption).click().perform();
	}

	
	public void addProduct()
	{
	    wait.until(ExpectedConditions.visibilityOf(firstProductAddCart));

	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", firstProductAddCart);

	    wait.until(ExpectedConditions.elementToBeClickable(firstProductAddCart));

	    js.executeScript("arguments[0].click();", firstProductAddCart);
	}
	
	}

