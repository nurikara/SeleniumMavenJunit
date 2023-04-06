package Odevler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev_05 extends TestBase {
    //    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
//            -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
//-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız


    @Test
    public void test01() {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();


        Alert MyAlert = driver.switchTo().alert();

        System.out.println(MyAlert.getText());

        MyAlert.accept();

    }

    @Test
    public void test02() {
        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
//-Çıkan alert'te iptal butonuna basınız

        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void test03() throws InterruptedException {
        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
//-Çıkan mesajı konsola yazdırınız
//-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(3000);
        Alert MyAlert = driver.switchTo().alert();
        MyAlert.sendKeys("Nuri");
        MyAlert.accept();

       String actualText = driver.findElement(By.xpath("//p[text()='Hello Nuri How are you today']")).getText();

       String expectedText = "Hello Nuri How are you today";

        Assert.assertEquals(expectedText, actualText);

    }


}
