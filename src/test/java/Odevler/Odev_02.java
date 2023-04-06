package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev_02 {


    //        *** Aşağıdaki Task'i Junit framework'u ile yapınız
//
//2qqq
//        - 100 defa basıldığını test edinizq
//        - 90 defa delete butonuna basınız
//        - 90 defa basıldığını doğrulayınız
//                - Sayfayı kapatınız

    public static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public static void tearDown() throws Exception {

//        driver.close();
    }


    @Test
    public void test01() {
        //- Add Element butonuna 100 defa basınız
        WebElement add = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i = 0; i < 100; i++) {

            add.click();
        }
    }

    @Test
    public void test02() {

       List<WebElement> delete = driver.findElements(By.xpath("//button[@class='added-manually']"));

        for (int i = 0; i <90 ; i++) {

            delete.get(i).click();

        }}

    @Test
    public void test03() {

        List<WebElement> delete = driver.findElements(By.xpath("//button[@class='added-manually']"));

     delete.size();

      if(delete.size()==10){

          System.out.println("Test PASSED");
      } else System.out.println("test FAILED");


    }
}




