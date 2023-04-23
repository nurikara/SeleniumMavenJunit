package day16_seleniumExceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test01() {

        driver.get("http://techproeducation.com");

        driver.get("https://www.techproeducation.com");
        wait(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum



    }
}
