package practice05DT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_WindowHandle extends TestBase {

    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com ");
        String amazonWindowHandle = driver.getWindowHandle();
        // 2- url'in 'amazon' icerdigini test edelim
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("amazon"));
        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String second = driver.getWindowHandle();
        // 4- title'in 'Best Buy' icerdigini test edelim
        String title = driver.getTitle();
        assertTrue(title.contains("Best Buy"));
        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java", Keys.ENTER);
        // 6- arama sonuclarının 'Java' icerdigini test edelim

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(second);

// 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
        assertTrue(logo.isDisplayed());
    }
}
