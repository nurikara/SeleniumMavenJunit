package practice04DT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02 extends TestBase {

//    https://the-internet.herokuapp.com/dynamic_loading/1
//    Start buttonuna tıklayın
//    Hello World! Yazının sitede oldugunu test edin


    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//    Start buttonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Start']")).click();
//    Hello World! Yazının sitede oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assert.assertTrue(helloWorld.isDisplayed());;


    }
}
