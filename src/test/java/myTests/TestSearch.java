package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Common;
import helpers.Waiters;

public class TestSearch extends Common {
	
	@Test(enabled=false, description = "Search by dresses")
	public void searchDresses() {
	    pIndex.search("DRESSES");
		String expectedBannerText = "\"DRESSES\"";
		Assert.assertEquals(pItems.getTitleText(), expectedBannerText);
		String expectedFirstItemText = "Printed Summer Dress";
		Assert.assertEquals(pItems.getFirstItemText(), expectedFirstItemText);
	}
	
	@Test(enabled=false, description = "Search by unexisting item")
	public void searchNoresults() {
		pIndex.search("hello world");
		String expectedBannerText = "No results were found for your search \"hello world\"";
		Assert.assertEquals(pItems.getNotFoundText(), expectedBannerText);
	}
	
	@Test(enabled=false, description = "Search by t-shirts")
	public void searchTshirts() {
		pIndex.search("T-SHIRTS");
		//String expectedBannerText = "\"T-SHIRTS\"";
		String expectedBannerText = "\"LOL\"";
		Assert.assertEquals(pItems.getTitleText(), expectedBannerText);
		String expectedFirstItemText = "Faded Short Sleeve T-shirts";
		Assert.assertEquals(pItems.getFirstItemText(), expectedFirstItemText);
	}
	
	@Test(enabled=false, description = "Click on first checkbox")
	public void clickOnFirstCheckbox() {
		pIndex.clickDresses();
	    pItems.clickOnFirstCheckbox();
	    Waiters.waitForTime(3);
	}
	
	@Test(enabled = false, description = "Click on all checkboxes")
	public void clickOnAllCheckboxes() {
		pIndex.clickDresses();
	    pItems.clickOnAllCheckboxes();
	    Waiters.waitForTime(3);
	}
	
	@Test(enabled = false, description = "Click on checkbox by index")
	public void clickOnCheckboxByIndex() {
		pIndex.clickDresses();
	    pItems.clickOnCheckboxByIndex(10);
	    Waiters.waitForTime(3);
	}
	
	@Test(description = "Click on checkbox by link text")
	public void clickOnCheckboxByText() {
		pIndex.clickDresses();
	    pItems.clickOnCheckboxByText("Summer Dresses");
	    Waiters.waitForTime(3);
	}
	
}
