package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageItems {
	private WebDriver driver;
	private By titleBanner;
	private By titleNotFound;
	
	public PageItems(WebDriver driver) {
		this.driver = driver;
		titleBanner = By.className("lighter");
		titleNotFound = By.xpath("//*[@id=\"center_column\"]/p");
	}
	
	public String getTitleText() {
		return driver.findElement(titleBanner).getText();
	}
	
	public String getNotFoundText () {
		return driver.findElement(titleNotFound).getText();
	}
	
}
