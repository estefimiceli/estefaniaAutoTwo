package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageIndex {
	private WebDriver driver;
	private By searchText;
	private By searchButton;
	private By womenLink;
	
	public PageIndex(WebDriver driver) {
		this.driver = driver;
		searchText = By.id("search_query_top");
		searchButton = By.name("submit_search");
		womenLink = By.linkText("WOMEN");
	}
	
	public void search(String termToSearch) {
		driver.findElement(searchText).sendKeys(termToSearch);
		driver.findElement(searchButton).click();
	}
	
	public void clickWomen() {
		driver.findElement(womenLink);
	}
}
