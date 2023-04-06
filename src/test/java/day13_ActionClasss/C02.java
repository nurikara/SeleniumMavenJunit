package day13_ActionClasss;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void test01() {
//
//        Amazon anasayfasına gidin
        driver.get("http://www.amazon.com");
//        "Account & List" üzerinde bekleyin (mouse over - hover over)
        WebElement account =driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(account).perform();




//        Açılan menüde "Account" linkine tıklayın
      driver.findElement(By.xpath("//span[text()='Account']")).click();
//        Açılan menüde "Account" linkine tıklayın
//        Açılan menüde "Account" linkine tıklayın
//        Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
    }
}
