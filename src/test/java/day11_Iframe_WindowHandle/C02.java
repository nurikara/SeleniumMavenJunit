package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02 extends TestBase {



    @Test
    public void test01() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz

        driver.get("https://www.techproeducation.com");
        String techProWindowHandle = driver.getWindowHandle();
        System.out.println("techProWindowHandle = " + techProWindowHandle);
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle ="Techpro Education | Online It Courses & Bootcamps";

        Assert.assertEquals(actualTitle,expectedTitle);
        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youTubeWindowHandle = driver.getWindowHandle();
        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        wait(2);

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("windowList = " + windowList);


        //techproeducation sayfasına geçiniz:
        //driver.switchTo().window(techProWindowHandle);
        driver.switchTo().window(windowList.get(0));
        wait(2);
        //youtube sayfasına geçiniz:
        wait(2);
        //driver.switchTo().window(youTubeWindowHandle);
        driver.switchTo().window(windowList.get(1));

        wait(2);
        //linkedIn sayfasına geçiniz:
        //driver.switchTo().window(linkedinWindowHandle);
        driver.switchTo().window(windowList.get(2));







    }
}
