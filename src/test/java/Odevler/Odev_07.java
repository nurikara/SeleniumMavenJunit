package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Odev_07 extends TestBase {


    @Test
    public void Test01() {

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// ikinci emojiye tıklayın
        driver.switchTo().frame(1);
        WebElement emoji2 = driver.findElement(By.xpath("//a[@href='#nature']"));
        emoji2.click();
        // tüm ikinci emoji öğelerini yazdirin
      List<WebElement> emojies = driver.findElements(By.xpath("//div[@id='nature']"));

        for (WebElement emojy : emojies) {
            System.out.println("emojy.getText() = " + emojy.getText());

        }
// parent iframe e geri donun
        driver.switchTo().defaultContent();
// formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        list.get(0).sendKeys("adi1");
        list.get(1).sendKeys("adi2");
        list.get(2).sendKeys("adi3");
        list.get(3).sendKeys("adi4");
        list.get(4).sendKeys("adi5");
        list.get(5).sendKeys("adi6");
        list.get(6).sendKeys("adi7");
        list.get(7).sendKeys("adi8");
        list.get(8).sendKeys("adi9");
        list.get(9).sendKeys("adi9");
        list.get(10).sendKeys("adi9");



// apply button a basiniz

        driver.findElement(By.xpath("//button[@id='send']")).click();
        wait(3);
        driver.close();


    }


}
