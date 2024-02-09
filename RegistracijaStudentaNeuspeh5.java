package artId;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistracijaStudentaNeuspeh5 {
  @Test
  public void registracijaStudentaNeuspesnaMejlPoljePrazno() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\TS\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost/projekat3/projekatIP/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("REGISTRUJ SE:")).click();
		driver.findElement(By.name("Potvrdi")).click();
		driver.findElement(By.name("kime")).sendKeys("KorisnikTest3");
		driver.findElement(By.name("sifra")).sendKeys("Sifra123$.");
		driver.findElement(By.name("ime")).sendKeys("ime");
		driver.findElement(By.name("prezime")).sendKeys("prezime");
		driver.findElement(By.name("telefon")).sendKeys("065777999");
		driver.findElement(By.name("godstudija")).sendKeys("2");
		driver.findElement(By.xpath("//input[@value='ne']")).click();
		WebElement slika=driver.findElement(By.name("slika"));
		slika.sendKeys("C:\\wamp64\\www\\projekat1\\JobFair\\img\\studenti\\bojan.png");
		
		driver.findElement(By.name("Registruj")).click();
		
		Alert err = driver.switchTo().alert();
		String errTxt = err.getText();
		
		try {
			Assert.assertTrue(errTxt.contains("Polje mejl ne sme biti prazno!"));
			System.out.println("registracija neuspesna jer je polje mejl prazno Pass");
		} catch (Exception e) {
			System.out.println("registracija neuspesna jer je polje mejl prazno Fail");
		}
		driver.quit();
  }
}
