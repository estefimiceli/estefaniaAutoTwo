package myTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PageIndex;
import pages.PageItems;

public class TestSearch {
	private WebDriver driver;
	private PageIndex pIndex;
	private PageItems pItems;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.navigate().to("http://automationpractice.com/index.php");
		pIndex = new PageIndex(driver);
		pItems = new PageItems(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void searchDresses() {
	    pIndex.search("DRESSES");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedBannerText = "\"DRESSES\"";
		Assert.assertEquals(pItems.getTitleText(), expectedBannerText);
		String expectedFirstItemText = "Printed Summer Dress";
		Assert.assertEquals(pItems.getFirstItemText(), expectedFirstItemText);
	}
	
	@Test
	public void searchNoresults() {
		pIndex.search("hello world");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedBannerText = "No results were found for your search \"hello world\"";
		Assert.assertEquals(pItems.getNotFoundText(), expectedBannerText);
	}
	
	@Test
	public void searchTshirts() {
		pIndex.search("T-SHIRTS");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedBannerText = "\"T-SHIRTS\"";
		Assert.assertEquals(pItems.getTitleText(), expectedBannerText);
		String expectedFirstItemText = "Faded Short Sleeve T-shirts";
		Assert.assertEquals(pItems.getFirstItemText(), expectedFirstItemText);
	}
	
}
