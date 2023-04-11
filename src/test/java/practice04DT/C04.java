package practice04DT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04 extends TestBase {
    @Test
    public void test01() {

        /*
/*
https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
Add tuşuna basın
"It's gone!" yazısını doğrulayın
 */



        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@autocomplete='off']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());
    }
}
