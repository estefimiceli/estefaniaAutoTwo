package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageIndex {
	private WebDriver driver;
	private By searchText;
	private By searchButton;
	private By womenLink;
	private By dressesLink;
	
	public PageIndex(WebDriver driver) {
		this.driver = driver;
		searchText = By.id("search_query_top");
		searchButton = By.name("submit_search");
		womenLink = By.linkText("Women");
		dressesLink = By.linkText("DRESSES");
	}
	
	public void search(String termToSearch) {
		driver.findElement(searchText).sendKeys(termToSearch);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement button;
		//explicit wait espera a que cierta condicion de un elemento suceda durante cierta cantidad de tiempo
		button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		button.click();
	}
	
	public void clickWomen() {
		driver.findElement(womenLink).click();
	}
	
	public void clickDresses() {
		driver.findElement(dressesLink).click();
	}
}
