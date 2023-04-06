package day12_WindowHandleDT;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C03_BasicAuthentication extends TestBase {
    @Test
    public void test01() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String prg=driver.findElement(By.xpath("//p")).getText();

        assertTrue(prg.contains("Congratulations! "));
    }
}
