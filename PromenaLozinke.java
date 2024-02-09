package artId;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class PromenaLozinke {

	@BeforeTest
	public void f() {

	}

	@Test
	public void promenaLozinkeNeuspesnaSifraPrekratka() {

		System.out.println("PromenaLozinke");
		// System.setProperty("webdriver.gecko.driver","C:\\Users\\TS\\Desktop\\geckodriver.exe");
		System.setProperty("webdriver.edge.driver", "C:\\Users\\TS\\Desktop\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost/projekat3/projekatIP/index.php");
		driver.manage().window().maximize();

		// driver = new FirefoxDriver();
		// driver.get(baseURL);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("PROMENI LOZINKU:")).click();
		driver.findElement(By.name("user")).sendKeys("stevica");
		driver.findElement(By.name("passstari")).sendKeys("Admin123.");
		driver.findElement(By.name("sifra")).sendKeys("Adm123.");

		driver.findElement(By.name("potvrdi")).click();

		Alert err = driver.switchTo().alert();
		String errTxt = err.getText();
		try {
			Assert.assertTrue(errTxt.contains("Sifra mora imati od 8 do 12 karaktera!"));
			System.out.println("Neuspesna promena lozinke PASS");
		} catch (Exception e) {
			System.out.println("Neuspesna promena lozinke FAIL");
		}
		if (driver != null)
			driver.quit();
	}
}
