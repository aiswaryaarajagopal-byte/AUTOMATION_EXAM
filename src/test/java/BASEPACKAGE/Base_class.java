package BASEPACKAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PAGEPACKAGE.Page_class;


public class Base_class {
	
	public static WebDriver driver;

    public Page_class objHome;
    

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.houseofem5.com/");
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void createObjects() {
        objHome = new Page_class(driver);
        
    }
        

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

	
	

}
