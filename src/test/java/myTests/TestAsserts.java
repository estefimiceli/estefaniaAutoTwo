package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAsserts {
	private String a;
	@Test
	public void isEqualChar() {
		a =  "a";
		Assert.assertEquals(a, "a", "Expected to have b\n"); //si esto falla, lo demas no se ejecuta. Es decir, corta la ejecucion
		System.out.println("Paso esto");
	}
	
	@Test
	public void isEqualNumber() {
		Assert.assertEquals(1, 2-1, "Expected to be 1\n");
	}
	
	@Test
	public void isNotEqual() {
		Assert.assertNotEquals(1, 2, "Expected to be different\n");
	}
	
	@Test
	public void isTrue() {
		Assert.assertTrue(8/2==4, "Expected to be true\n"); //se le pasa expresion como parametro q debe ser verdadera
	}
	
	@Test
	public void isFalse() {
		Assert.assertFalse("hola"=="chau", "Expected to be false\n"); 
	}
	
	@Test
	public void isNull() {
		String var = null;
		Assert.assertNull(var, "Expected to be null\n");
	}
	
	@Test
	public void isNotNull() {
		Assert.assertNotNull("b");
	}
}