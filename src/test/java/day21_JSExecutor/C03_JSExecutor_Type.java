package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Type extends TestBase {
    @Test
    public void test01() {

//Techpro education ana sayfasina git

        driver.get("https://techproeducation.com");
        wait(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz
        WebElement search = driver.findElement(By.xpath("//*[@title='Search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*
         Bazi giriş kutuları normal sendKeys() methodu ile metin gönderilmesine izin vermez.
         Bu gibi durumlarda aşağıdaki örnekteki gibi JSExecutor kullanılır.
         */
        js.executeScript("arguments[0].value='QA'",search);


    }
}
