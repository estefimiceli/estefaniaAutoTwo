package myTests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAsserts {
	@Test
	public void softAsserts() {
		SoftAssert sa = new SoftAssert();
		//sa.assertEquals(1, 2, "Elements are not equal\n");
		System.out.println("The test continues..\n");
		sa.assertEquals(2, 2, "Elements are not equal\n");
		sa.assertAll();
	}
}
