package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageItems {
	private WebDriver driver;
	private By titleBanner;
	private By titleNotFound;
	private By firstItemTitle;
	
	public PageItems(WebDriver driver) {
		this.driver = driver;
		titleBanner = By.className("lighter");
		titleNotFound = By.xpath("//*[@id=\"center_column\"]/p");
		firstItemTitle = By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a");
	}
	
	public String getTitleText() {
		return driver.findElement(titleBanner).getText();
	}
	
	public String getNotFoundText () {
		return driver.findElement(titleNotFound).getText();
	}
	
	public String getFirstItemText() {
		return driver.findElement(firstItemTitle).getText();
	}
	
}
