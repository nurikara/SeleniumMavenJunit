package day21_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecutor_Scroll extends TestBase {
    JavascriptExecutor js;

    @Test
    public void jsExecutorScrollTest() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        wait(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//*[text()='we offer']"));
        wait(2);

        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);

        wait(2);

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree = driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);


        wait(2);

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al

        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));

        js.executeScript("arguments[0].scrollIntoView(true);", whyUs);

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al

        js.executeScript("arguments[0].scrollIntoView(true);", enrollFree);

        // Sayfasi Enalta Scroll Yapalim
        js.executeScript("window.scrollTo,document.body.scrollTop");



    }
}
