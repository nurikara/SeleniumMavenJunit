package practice05DT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03 extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1 adresine gidelim
//start butonuna tıklayalım
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//*[.='Start']\n")).click();
        WebElement hello= driver.findElement(By.xpath("(//h4)[2]"));

        visibleWait(hello,2);
        Assert.assertTrue(hello.isDisplayed());
    }
}
