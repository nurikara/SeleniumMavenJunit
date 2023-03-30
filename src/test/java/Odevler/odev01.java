package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class odev01 {
    //
//    *** Aşağıdaki Task'i Junit framework'u ile yapınız
//- ebay sayfasına gidiniz
//- electronics bölümüne tıklayınız
//- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
//- Her sayfanın sayfa başlığını yazdıralım
//- sayfayı kapatalım
    static WebDriver driver;

    @BeforeClass

    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://ebay.com");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        for (int i =0;i<24 ; i++) {

            List<WebElement> pictures = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));

            pictures.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();

        }


        //- Her sayfanın sayfa başlığını yazdıralım
    }


}
