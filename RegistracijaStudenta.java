package artId;

import static artId.HelpingClass.baseURL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistracijaStudenta {
  
	@BeforeTest
	public void pokretanje() {
		baseURL="http://localhost/projekat3/projekatIP/";
		System.out.println("heyIzRegistracije");
	}
	
	@Test
  public void registracija() {
		//baseURL="http://localhost/projekat3/projekatIP/";
		System.setProperty("webdriver.edge.driver", "C:\\Users\\TS\\Desktop\\msedgedriver.exe");
		System.out.println(System.getProperty("webdriver.edge.driver")); 
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://localhost/projekat3/projekatIP/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("REGISTRUJ SE:")).click();
		driver.findElement(By.name("Potvrdi")).click();
		driver.findElement(By.name("kime")).sendKeys("KorisnikTest");
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
			String welcomeMsg=driver.findElement(By.id("regstudent1")).getText();
			Assert.assertTrue(welcomeMsg.contains("Uspesno ste se registrovali!"));
			System.out.println("Register Pass");
		} catch (Exception e) {
			System.out.println("Register Fail");
		}
		driver.quit();
  }
}
