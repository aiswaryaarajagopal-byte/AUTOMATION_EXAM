package TESTPACKAGE;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import BASEPACKAGE.Base_class;

public class Test_class extends Base_class {
	
	
	// Verify Title
	@Test(priority=1)
	public void verifyTitle()
	{
		String actualTitle = driver.getTitle();
		String expectedTitle = "Best Body Perfume Brand for Men and Women Online in India – House of EM5";

		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title verified successfully");
	}

	
	// Login
	@Test(priority=2)
	public void loginTest()
	{
		objHome.login("Demouserbot07@gmail.com","123123");
		System.out.println("Login successful");
	}

	
	// Hover collections
	@Test(priority=3)
	public void hoverCollection()
	{
		objHome.hoverCollectionAndSelectFirst();
		System.out.println("Collection selected");
	}

	
	// Add Product
	@Test(priority=4)
	public void addProductToCart()
	{
		objHome.addProduct();
		System.out.println("Product successfully added to cart");
	}
	
	// Take Screenshot
		@Test(priority=5)
		public void takeScreenshot() throws Exception
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(src,new File("./Screenshot/product.png"));

			System.out.println("Screenshot captured");
		}

}