package artId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistracijaKompanije {
	private SoftAssert softAssert = new SoftAssert();
	
  @Test
  public void registracija() {
	  System.setProperty("webdriver.edge.driver", "C:\\Users\\TS\\Desktop\\msedgedriver.exe");
		System.out.println(System.getProperty("webdriver.edge.driver")); 
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://localhost/projekat3/projekatIP/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("REGISTRUJ SE:")).click();
		Select select= new Select(driver.findElement(By.name("reg")));
		select.selectByValue("Kompanija");
		driver.findElement(By.name("Potvrdi")).click();
		driver.findElement(By.name("kime")).sendKeys("KompaniKompani");
		driver.findElement(By.name("sifra")).sendKeys("sIfra123.");
		driver.findElement(By.name("naziv")).sendKeys("KompaniKompani");
		driver.findElement(By.name("grad")).sendKeys("Beograd");
		driver.findElement(By.name("adresa")).sendKeys("Ulica Br1");
		driver.findElement(By.name("imedir")).sendKeys("Steva Jankovic");
		driver.findElement(By.name("pib")).sendKeys("7483479312");
		driver.findElement(By.name("brzaposlenih")).sendKeys("100");
		driver.findElement(By.name("mejl")).sendKeys("kompani@wow");
		driver.findElement(By.name("sajt")).sendKeys("KompaniWOW.com");
		Select select2=new Select(driver.findElement(By.name("delatnost")));
		select2.selectByValue("Telekomunikacije");
		WebElement slika=driver.findElement(By.name("slika"));
		slika.sendKeys("C:\\wamp64\\www\\projekat1\\JobFair\\img\\kompanije\\elsys.jpg");
		
		driver.findElement(By.name("Registruj")).click();
		
		try {
			String welcomeMsg=driver.findElement(By.id("regstudent1")).getText();
			driver.quit();
			Assert.assertTrue(welcomeMsg.contains("Uspesno ste se registrovali!"));
			System.out.println("Register Pass");
		} catch (Exception e) {
			System.out.println("Register Fail");
		}
		driver.quit();
  }
}
