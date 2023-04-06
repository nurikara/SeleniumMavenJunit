package day09_dropDown;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {

    @Test
    public void test01 () {

        driver.get("https://techproeducation.com");
        //Basligin "Bootcamp" icerdigini test edin
        String actualTitle =driver.getTitle();
        String expectedTitle = "Boothcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
