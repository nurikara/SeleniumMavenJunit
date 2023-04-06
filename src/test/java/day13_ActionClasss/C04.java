package day13_ActionClasss;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04 extends TestBase {



    @Test
    public void test01() {
        //    https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//            "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
       driver.switchTo().frame(0);

        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
       WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();
    }

    @Test
    public void test02() {
        driver.get("https://jqueryui.com/droppable/");

//            "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(drag).moveToElement(drop).release().perform();



    }

    @Test
    public void test03() {
        driver.get("https://jqueryui.com/droppable/");

//            "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(drag).moveByOffset(170,20).release().perform();
    }
}
