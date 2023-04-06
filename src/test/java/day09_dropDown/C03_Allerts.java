package day09_dropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Allerts extends TestBase {

/*    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

 */

    @Test
    public void allerts() throws InterruptedException {


//        https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        String acctualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText = "You successfully clicked an alert";

        Assert.assertEquals(acctualText, acctualText);
//        Bir metod olusturun: acceptAlert
//        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.


//                Bir metod olusturun: dismissAlert
//        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//“successfuly” icermedigini test edin.
//                Bir metod olusturun: sendKeysAlert
//        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    }

    @Test
    public void dismiss() {

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        driver.switchTo().alert().dismiss();

        String actualtext = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedtex = "successfuly";

        Assert.assertNotEquals(actualtext, expectedtex);
    }

    @Test
    public void sendKeysAlert() throws InterruptedException {


        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Erol");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        WebElement result = driver.findElement(By.cssSelector("p[id='result']"));
        Assert.assertTrue(result.getText().contains("Erol"));
        System.out.println(result.getText());


    } }
