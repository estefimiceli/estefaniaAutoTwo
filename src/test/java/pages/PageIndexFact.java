package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// con page factory los elementos se inicializan desde el momento 0

public class PageIndexFact {
	private WebDriver driver;
	
	@FindBy(id="search_query_top")
	private WebElement searchText;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	@FindBy(className="sf-with-ul")
	private WebElement womenLink;
	
	@FindBy(linkText="DRESSES")
	private WebElement dressLink;
	
	public PageIndexFact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search(String termToSearch) {
		searchText.sendKeys(termToSearch);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement button;
		//explicit wait espera a que cierta condicion de un elemento suceda durante cierta cantidad de tiempo
		button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		button.click();
	}
	
	public void clickWomen() {
		womenLink.click();
	}
	
	public void clickDresses() {
		dressLink.click();
	}
}
