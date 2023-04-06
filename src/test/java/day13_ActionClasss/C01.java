package day13_ActionClasss;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01 extends TestBase {




    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
//    Kutuya sağ tıklayın
       WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
//    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
       String alerttext= driver.switchTo().alert().getText();
       String accualtext= "You selected a context menu";
        Assert.assertEquals(alerttext,accualtext);
//    Tamam diyerek alert’i kapatın
       alertAccept();

    }
}
