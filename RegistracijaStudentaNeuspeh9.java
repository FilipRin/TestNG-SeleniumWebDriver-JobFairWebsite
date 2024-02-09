package artId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistracijaStudentaNeuspeh9 {
  @Test
  public void registracijaStudentaNeuspesnaKorisnickoImeVecPostoji() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\TS\\Desktop\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://localhost/projekat3/projekatIP/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("REGISTRUJ SE:")).click();
		driver.findElement(By.name("Potvrdi")).click();
		driver.findElement(By.name("kime")).sendKeys("stevica");
		driver.findElement(By.name("sifra")).sendKeys("Sifra123$.");
		driver.findElement(By.name("ime")).sendKeys("ime");
		driver.findElement(By.name("prezime")).sendKeys("prezime");
		driver.findElement(By.name("telefon")).sendKeys("065777999");
		driver.findElement(By.name("mejl")).sendKeys("ime@prezime");
		driver.findElement(By.name("godstudija")).sendKeys("2");
		driver.findElement(By.xpath("//input[@value='ne']")).click();
		WebElement slika=driver.findElement(By.name("slika"));
		slika.sendKeys("C:\\wamp64\\www\\projekat1\\JobFair\\img\\studenti\\bojan.png");
		
		driver.findElement(By.name("Registruj")).click();
		
		try {
			String ErrorMsg=driver.findElement(By.id("regstudent1")).getText();
			Assert.assertTrue(ErrorMsg.contains("Postoji ovo korisnicko ime u sistemu!"));
			System.out.println("Registracija neuspesna, postoji ovo kor. ime Pass");
		} catch (Exception e) {
			System.out.println("Registracija neuspesna, postoji ovo kor. ime Fail");
		}
		driver.quit();
  }
}
