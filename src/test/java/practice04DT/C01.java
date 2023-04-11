package practice04DT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test01() {

//https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");

//logo.jpeg dosyasını yükleyin(uopload)
        //"C:\Users\nurik\Desktop\lojo.jpeg.txt"
        WebElement choosefile =driver.findElement(By.id("file-upload"));
        wait(3);
        choosefile.sendKeys(System.getProperty("user.home")+"\\Desktop\\lojo.jpeg.txt");
//"File Uploaded!" textinin görüntülendiğini test edin
      driver.findElement(By.id("file-submit")).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());

    }
}
