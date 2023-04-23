package Odevler;

import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Odev_10 extends TestBase {
    @Test
    public void test01() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
//Click me, to open an alert after 5 seconds butonuna basalım
//Çıkan alert'i kapatalım

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        WebElement element = driver.findElement(By.xpath("//button[@id='alert']"));
        element.click();

        // WebDriverWait nesnesi oluşturulur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



// Tıklanabilir öğe bulunur ve beklenir
        wait.until(ExpectedConditions.alertIsPresent());


        Alert alert = driver.switchTo().alert();
        alert.accept();


        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sitesine gidin
// 'Enable button after 10 seconds' butonuna tiklayin.
// 'Button'un tiklanabilir oldugunu test edin.

        WebElement button = driver.findElement(By.xpath("//button[@id='enable-button']"));
        button.click();
        WebElement button11 = driver.findElement(By.xpath("//button[@id='disable']"));
        wait.until(ExpectedConditions.visibilityOf(button11));
        Assert.assertTrue(button11.isDisplayed());


//https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sitesine git
// 'Check Checkbox after 10 seconds' butonuna tikla
// 'checkbox' butonunun tiklandigini test edin.
        driver.findElement(By.xpath("//button[@id='checkbox']")).click();
        WebElement tick = driver.findElement(By.xpath("//input[@id='ch']"));
        wait.until(ExpectedConditions.elementToBeSelected(tick));

        Assert.assertTrue(tick.isEnabled());


    }
}
