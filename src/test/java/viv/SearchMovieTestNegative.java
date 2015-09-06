package viv;

import java.util.regex.Pattern;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;

import com.thoughtworks.selenium.Wait;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchMovieTestNegative extends TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void SearchMovieTestNegative() throws Exception {

    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("submit")).click();
//    WebElement film = driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div[3]/a[1]/div/div[2]"));
    String filmName = "kfdjierp842^9D±-";
    List<WebElement> FilmsCollection = driver.findElements(By.className("movie_box"));
    int totalFilmsCollection = FilmsCollection.size();
    Assert.assertTrue(0 < totalFilmsCollection); 
    driver.findElement(By.id("q")).clear();
    driver.findElement(By.id("q")).sendKeys(filmName);  
    driver.findElement(By.id("q")).sendKeys(Keys.RETURN);
//    isElementPresent(By.partialLinkText(filmName));
    List<WebElement> FilmsSearch = driver.findElements(By.className("movie_box"));
    int totalFilmsSearch = FilmsSearch.size();
    WebDriverWait wait = new WebDriverWait(driver, 30);
//    WebElement element = wait.until(totalFilmsSearch == 0);
    Assert.assertFalse(totalFilmsSearch == 0);
//    Assert.assertTrue(0 < totalFilmsCollection);    
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