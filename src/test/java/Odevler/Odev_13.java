package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.function.Function;

public class Odev_13 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım


        int randomNum1 = (int) ((Math.random() * 9) + 1);
        driver.findElement(By.xpath("//span[text()='" + randomNum1 + "']")).click();

        int randomNum2 = (int) (Math.random() * 10);
        driver.findElement(By.xpath("//span[text()='" + randomNum2 + "']")).click();

        int randomNum3 = (int) (Math.random() * 4);

        String firstNumber = randomNum1 + "" + randomNum2;
        int intfirstNumber = Integer.parseInt(firstNumber);


        switch (randomNum3) {
            case 0:
                driver.findElement(By.xpath("//span[text()='+']")).click();
                break;
            case 1:
                driver.findElement(By.xpath("//span[text()='-']")).click();
                break;
            case 2:
                driver.findElement(By.xpath("//span[text()='÷']")).click();
                break;
            case 3:
                driver.findElement(By.xpath("//span[text()='x']")).click();
                break;
        }

        int randomNum4 = (int) ((Math.random() * 9) + 1);
        driver.findElement(By.xpath("//span[text()='" + randomNum4 + "']")).click();

        int randomNum5 = (int) (Math.random() * 10);
        driver.findElement(By.xpath("//span[text()='" + randomNum5 + "']")).click();

        driver.findElement(By.xpath("//span[text()='=']")).click();
        Thread.sleep(6000);
        WebElement sonucHesapMakinesi = driver.findElement(By.xpath("//div[@class=\"screen\"]"));


        String secondNumber = randomNum4 + "" + randomNum5;
        int intsecondNumber = Integer.parseInt(secondNumber);


        //Sonucu konsola yazdırı
        int Sonuc = 2;
        switch (randomNum3) {
            case 0:
                Sonuc = intfirstNumber + intsecondNumber;
                break;
            case 1:
                Sonuc = intfirstNumber - intsecondNumber;
                break;
            case 2:
                Sonuc = intfirstNumber / intsecondNumber;
                break;

            case 3:
                Sonuc = intfirstNumber * intsecondNumber;
                break;
        }
        System.out.println("Sonuc = " + Sonuc);

        int intsonucHesapMakinesi = Integer.parseInt(sonucHesapMakinesi.getText());
        System.out.println("intsonucHesapMakinesi = " + intsonucHesapMakinesi);

        //Sonucun doğrulamasını yapalım
        Assert.assertEquals(Sonuc,intsonucHesapMakinesi);
    }
}
