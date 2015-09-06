package viv;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;

import com.thoughtworks.selenium.Wait;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RemoveMovieTest extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void RemoveMovieTest() throws Exception {

    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
    WebElement film = driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[3]/a[1]/div/div[2]"));
    String filmName = film.getText();
    film.click();
    driver.findElement(By.linkText("Remove")).click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    isElementNoPresent(By.partialLinkText(filmName));   
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isElementNoPresent(By by) {
	    try {
	      driver.findElement(by);
	      return false;
	    } catch (NoSuchElementException e) {
	      return true;
	    }
	  }
  
  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}