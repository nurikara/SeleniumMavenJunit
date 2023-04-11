package day14_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01 extends TestBase {




    @Test

    public void test01() {
        //    "https://techproeducation.com/" gidin
        //    İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
        driver.get("https://techproeducation.com/");
        driver.findElement(By.cssSelector("i[class='eicon-close']")).click();
        WebElement search = driver.findElement(By.xpath("//*[@type='search']"));

        Actions actions =new Actions(driver);

        actions.keyDown(search, Keys.SHIFT).
                sendKeys("techpro").
                keyUp(Keys.SHIFT).sendKeys(" education",Keys.ENTER).perform();

        WebElement richment = driver.findElement(By.xpath("(//h3[@class='elementor-post__title'])[9]"));

        actions.scrollToElement(richment).perform();
    }
}
