package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {



    @Test
    public void iframe() {
//        https://the-internet.herokuapp.com/iframe sayfasına gidiniz
//        Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement head = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(head.getText().contains("Editor"));
//        Textbox içindeki yazıyı siliniz.
        wait(2);
        driver.switchTo().frame(0);

        WebElement texbox = driver.findElement(By.xpath("//p"));
        texbox.clear();
        wait(2);
        // Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        texbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        // Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
       WebElement elementalSelenium= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSelenium.isDisplayed());
    }
}
