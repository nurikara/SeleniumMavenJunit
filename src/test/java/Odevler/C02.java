package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C02 {


    //        *** Aşağıdaki Task'i Junit framework'u ile yapınız
//
//2qqq
//        - 100 defa basıldığını test edinizq
//        - 90 defa delete butonuna basınız
//        - 90 defa basıldığını doğrulayınız
//                - Sayfayı kapatınız

    static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterClass
    public static void tearDown() throws Exception {

        driver.close();
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

        }}}




