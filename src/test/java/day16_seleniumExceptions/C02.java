package day16_seleniumExceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void test01() {
        /*
        TimeOutException:
            Sayfada aradığımız elementi wait ile belirlediğimiz max. sürede bulamadığı durumda
        TimeOutException hatası alırız.
         */
        driver.get("https://techproeducation.com");
        wait(5);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için
    }
}
