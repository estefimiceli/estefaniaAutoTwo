package myTests;

import org.testng.annotations.Test;
import base.Common;

public class TestSelectOrder extends Common {
	
	@Test(enabled=false)
	public void selectByVisibleText() {
		pIndex.clickWomen();
		pItems.selectElementByVisibleText("Price: Lowest first");
		pItems.selectElementByValue("quantity:desc");
		pItems.selectElementByIndex(4);
	}

}
