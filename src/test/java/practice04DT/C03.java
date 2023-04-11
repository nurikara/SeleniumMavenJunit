package practice04DT;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertTrue;

public class C03 extends TestBase {

    @Test
    public void test01() {

//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//        Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

//        Hello World! Yazının sitede oldugunu test edin
        //Fluent wait'in WebDriverWait'ten farkı 'wait' objesinin oluşturulmasında ortaya çıkar.
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).//Max bekleme süresi
                        pollingEvery(Duration.ofSeconds(3)).//Deneme aralıkları: Her 3 saniyede bir bulma denemesi yapar
                        withMessage("Ignore Exception").//Mesaj yazdırılabilir: Zorunlu değil.
                        ignoring(TimeoutException.class);//Exception handle edilebilir: zorunlu değil.

        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));

        assertTrue(helloWorldText.isDisplayed());

    }
}
