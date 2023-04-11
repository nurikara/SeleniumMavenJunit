package Odevler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev_09 extends TestBase {


    @Test
    public void test01() {

//        -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.switchTo().frame(0);
        WebElement red = driver.findElement(By.id("red"));
        WebElement green = driver.findElement(By.id("green"));
        WebElement blue = driver.findElement(By.id("blue"));



        Actions actions = new Actions(driver);

        actions.clickAndHold(green);

        for (int i = 0; i < 30; i++) {

            actions.moveByOffset(-5, 0);
        }

        actions.release().build().perform();
        wait(3);

        actions.clickAndHold(blue);

        for (int i = 0; i < 40; i++) {

            actions.moveByOffset(-5, 0);
        }

        actions.release().build().perform();

        wait(3);

        driver.close();

    }

    @Test
    public void test02() {
        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.switchTo().frame(0);
        WebElement red = driver.findElement(By.id("red"));
        WebElement green = driver.findElement(By.id("green"));
        WebElement blue = driver.findElement(By.id("blue"));



        Actions actions = new Actions(driver);

        actions.clickAndHold(green);

        for (int i = 0; i < 30; i++) {

            actions.moveByOffset(5, 0);
        }

        actions.release().build().perform();
        wait(3);

        actions.clickAndHold(blue);

        for (int i = 0; i < 70; i++) {

            actions.moveByOffset(-5, 0);
        }

        actions.release().build().perform();

        wait(3);

     WebElement background= driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 253, 0);']"));

     Assert.assertTrue(background.isDisplayed());


        wait(3);


       driver.close();
    }
}






//        -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız





