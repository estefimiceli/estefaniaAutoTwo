package helpers;

public class Waiters {
	public static void waitForTime(int seconds) {
		//con static se posibilita no tener que crear un objeto de la clase
		//para emplear el metodo. Solo se usa el metodo llamando a la clase
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
