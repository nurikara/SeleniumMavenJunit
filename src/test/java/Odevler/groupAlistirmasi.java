package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class groupAlistirmasi extends TestBase {

    @Test
    public void test1() {
        /*
	- https://demoqa.com/select-menu sitesine gidin
	- <select> elementini locate edin
	- <select> elementinin seceneklerini yazdirin
	- Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
	    * Yellow (index)
	    * Purple (value)
	    * Black  (text)
	    seceneklerini secin

         */
        driver.get("https://demoqa.com/select-menu");

        WebElement ddm = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(ddm);

        List<WebElement> list = select.getOptions();

        list.forEach(t -> System.out.println(t.getText()));

        select.selectByIndex(3);
        wait(3);

        select.selectByValue("4");
        wait(3);

        select.selectByVisibleText("Black");

    }
}
