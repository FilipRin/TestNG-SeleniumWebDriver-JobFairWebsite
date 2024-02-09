package artId;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentNeuspesanUnosStranogJezika {
  @Test
  public void unosStranogJezikaNeuspesanJezikNijeOdabran() {
	  System.out.println("unosStranogJezika");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\TS\\Desktop\\geckodriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\TS\\Desktop\\msedgedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost/projekat3/projekatIP/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user")).sendKeys("aleksa");
		driver.findElement(By.name("pass")).sendKeys("Sifra1234$");
		driver.findElement(By.name("potvrdi")).click();
		
		driver.findElement(By.linkText("AZURIRAJ BIOGRAFIJU")).click();
		driver.findElement(By.xpath("//a[@href='Jezici.php']")).click();
		driver.findElement(By.xpath("//input[@value='POTVRDI']")).click();
		
		Alert err = driver.switchTo().alert();
		String errTxt = err.getText();
		try {
			Assert.assertTrue(errTxt.contains("Polje jezik ne sme biti prazno!"));
			System.out.println("Neuspesan unos stranog jezika PASS");
		} catch (Exception e) {
			System.out.println("Neuspesan unos stranog jezika FAIL");
		}
		if (driver != null)
			driver.quit();
  }
}
