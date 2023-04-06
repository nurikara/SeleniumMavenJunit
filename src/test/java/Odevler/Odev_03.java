package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev_03 {
//    -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
//-Before methodunda http://www.google.com adresine gidin
//            -Üç farklı test methodu ile;
//-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
//-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
//-AfterClass ile kapatın

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp() throws Exception {
        driver.get("https://google.com");


    }


    @Test
    public void test01() throws Exception {


        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"gLFyf\"]"));
        searchBox.sendKeys("Lord of the Rings");
        searchBox.submit();
        Thread.sleep(3000);


    }

    @Test
    public void test02() throws Exception {


        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"gLFyf\"]"));
        searchBox.sendKeys("The God Father");
        searchBox.submit();
        Thread.sleep(3000);
    }

    @Test
    public void test03() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"gLFyf\"]"));
        searchBox.sendKeys("Kill Bill");
        searchBox.submit();
        Thread.sleep(3000);


    }


    @After
    public void tearDown() throws Exception {

        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(result.getText());
//        driver.close();
    }


    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();

    }
}
