package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageItems {
	private WebDriver driver;
	private By titleBanner;
	private By titleNotFound;
	private By firstItemTitle;
	private By orderSelect;
	private By checkBoxes;
	private By sectionTitle;
	
	public PageItems(WebDriver driver) {
		this.driver = driver;
		titleBanner = By.className("lighter");
		titleNotFound = By.xpath("//*[@id=\"center_column\"]/p");
		firstItemTitle = By.cssSelector("#center_column > ul > li > div > div.right-block > h5 > a");
		orderSelect = By.id("selectProductSort");
		checkBoxes = By.className("checkbox");
		sectionTitle = By.className("cat-name");
	}
	
	public void clickOnFirstCheckbox() {
		driver.findElement(checkBoxes).click();
	}
	
	public void clickOnAllCheckboxes() {
		List<WebElement> elements = driver.findElements(checkBoxes);
		System.out.println("TAMANIO ARRAYLIST " + elements.size());
		for(WebElement elem: elements) {
			elem.click();
		}
	}
	
	public void clickOnCheckboxByIndex(int indexToClick) {
		List<WebElement> elements = driver.findElements(checkBoxes);
		elements.get(indexToClick).click();
	}
	
	//para clickear en checkbox by texto, si no es un link, usar hashmaps
	public void clickOnCheckboxByText(String text){
		driver.findElement(By.linkText(text)).click();
	}
	
	public String getTitleText() {
		return driver.findElement(titleBanner).getText();
	}
	
	public String getSectionText() {
		return driver.findElement(sectionTitle).getText();
	}
	
	public String getNotFoundText () {
		return driver.findElement(titleNotFound).getText();
	}
	
	public String getFirstItemText() {
		return driver.findElement(firstItemTitle).getText();
	}
	
	public void selectElementByVisibleText(String text) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByVisibleText(text);
	}
	
	public void selectElementByValue(String value) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByValue(value);
	}
	
	public void selectElementByIndex(int index) {
		Select select = new Select(driver.findElement(orderSelect));
		select.selectByIndex(index);
	}
}
