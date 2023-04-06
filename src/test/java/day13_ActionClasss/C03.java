package day13_ActionClasss;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.WatchEvent;

public class C03 extends TestBase {


    @Test
    public void test01() {
        //    https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

//    Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();

wait(2);
//    Sayfanın üst tarafına gidin
        actions = new Actions(driver);
        actions.
                sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_UP).
                perform();

        wait(2);
        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();

        wait(5);
        actions.sendKeys(Keys.HOME).perform();

    }

    @Test
    public void test02() {

        driver.get("https://amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(Keys.SHIFT,"s",Keys.SHIFT,"amsung",Keys.ENTER);
    }
}
