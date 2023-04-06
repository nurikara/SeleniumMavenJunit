package day12_WindowHandleDT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C01_WindowHandle extends TestBase {


    @Test
    public void test01() {

//https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techProWH = driver.getWindowHandle();

//Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps", driver.getTitle());
//Tab 2'de https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youTubeWH = driver.getWindowHandle();
        assertEquals("YouTube", driver.getTitle());
//Tab 3'de https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedInWH = driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        //Tab 3'de https://www.techproeducation.com sayfasını açınız
        //Tab 3'te https://www.linkedin.com sayfasını açınız

        //techproeducation sayfasına geçiniz
        //youtube sayfasına geçiniz
        //linkedIn sayfasına geçiniz


        List<String> windowHL = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHL.get(0));
        wait(2);

        driver.switchTo().window(windowHL.get(1));
        wait(2);

        driver.switchTo().window(windowHL.get(2));
        wait(2);
    }

    @Test
    public void tet02() {
//        https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
       // Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps\"", driver.getTitle());

//     Tab 2'de https://www.google.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
//        Tab 3'te https://www.linkedin.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
//        Tab 3'te https://www.youtube.com sayfasını açınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
//        Tab 3'te https://www.techproeducation.com sayfasını açınız
//        techproeducation sayfasına geçiniz
        switchToWindow(0);
        wait(2);

//        youtube sayfasına geçiniz
        switchToWindow(1);
        wait(2);
//        linkedIn sayfasına geçiniz
        switchToWindow(2);
        wait(2);


    }
}
