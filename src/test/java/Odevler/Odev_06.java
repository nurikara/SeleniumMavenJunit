package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev_06 extends TestBase {


    @Test
    public void test01() {

        //● https://the-internet.herokuapp.com/iframe adresine
//gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");
//● Bir metod olusturun: iframeTest
//○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement text = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());
//○Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame(0);
        WebElement dr = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        dr.clear();
        dr.sendKeys("Merhaba Dunya");

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
//oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement dr2= driver.findElement(By.xpath("//a[@href='https://github.com/tourdedave/the-internet']"));
        Assert.assertTrue(dr2.isDisplayed());
        System.out.println( dr2.getText());


    }
}
