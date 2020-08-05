package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.PageIndex;
import pages.PageItems;

public class Common {
	protected WebDriver driver;
	protected PageIndex pIndex;
	protected PageItems pItems;
	
	
	//para ejecutar todos los tests del proyecto: mvn test -e
	//para ejecutar solo un test file (clase.java): mvn -Dtest=TestSearch test
	//para ejecutar solo un test del test file o de la clase.java: mvn -Dtest=TestSearch#clickOnCheckboxByText test
	//para ejecutar tests q empiecen con cierta palabra: mvn -Dtest=TestSearch#click* test
	//para ejecutar tests de un grupo: mvn -Dgroups=Group2 test
	
	//antes de que se ejecute cada test de un test file, se ejecuta esto
	@BeforeMethod(groups={"Group1","Group2"})
	public void setUp() {
//		if(System.getProperty("os.name").contains("Mac")) {
//			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//		}
		//System.out.println("EFIII " + System.getProperty("os.name"));
		//para ejecutar tests de ui en modo headless
		//modo headless: se levanta el mismo chrome en memoria, pero no es visible. En memoria todo se renderiza pero no lo ves en pantalla
		//en modo headless los screenshots siguen siendo captados
//		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//para ejecutar en modo incognito
//		options.addArguments("--incognito");
		//reemplaza a driver.manage().window().maximize()
//		options.addArguments("--start-fullscreen");
//		driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		// Set browser's window size
		//driver.manage().window().setSize(new Dimension(400, 500));
		// Set browser's window position
		//driver.manage().window().setPosition(new Point(500, 700));
//		for(int i = 0; i < 500; i++) {
//			for(int j = 0; j < 500; j++) {
//				driver.manage().window().setPosition(new Point(i, j));
//			}
//				
//		}
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--start-maximized");
		fo.addArguments("--incognito");
		driver = new FirefoxDriver(fo);
		//driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		pIndex = new PageIndex(driver);
		pItems = new PageItems(driver);
		//implicit wait, digo el tiempo maximo que va a esperar por un elemento. si no lo encuentra en ese tiempo falla el test (bug)
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod(groups={"Group1","Group2"})
	public void tearDown(ITestResult result) {
		// los reportes estan dentro del proyecto, en target, surefire reports: index.html and emaibable-report.html 
		//getStatus returns 1 if passes and another number if fails
		int status = result.getStatus();
		
		System.out.println(status);
		System.out.println("EL TEST " + result.getMethod().getDescription() + " RESULTA");
		
		if (status == 1) {
			System.out.println("EXITOSO");
		} else {
			System.out.println("FALLIDO");
		}
		
		//si el test falla, tomar screenshot
		if (!result.isSuccess()) {
			File sureFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(sureFile, new File("target/surefire-reports/" + result.getMethod().getDescription() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//driver.close();
		driver.quit();
	}
	
	//antes de que se ejecute cada clase (cada test file) se ejecuta esto
	@BeforeClass(groups={"Group1","Group2"})
	public void beforeAll() {
		System.out.println("creando la base de datos ...\n");
		System.out.println("base de datos creada ...\n");
	}

	@AfterClass(groups={"Group1","Group2"})
	public void afterAll() {
		System.out.println("borrando base de datos ...\n");
		System.out.println("base de datos borrada ...\n");
	}
	
}
