package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Odev_04 {
    //    -Amazon sayfasına gidelim
//-Arama Kutusundaki Dropdown menuyu yazdıralım
//-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
//            başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
//            Not: Select Class'ı kullanalım
// 
    public static WebDriver driver;
    static WebElement dropedown;


    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Before
    public void setUp() throws Exception {
        driver.get("https://amazon.com");
        dropedown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));

    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        System.out.println(dropedown.getText());


    }


    @Test
    public void test02() throws InterruptedException {
        int counter = 0;

        do {
            System.out.println("=================================");
            dropedown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
            Select dr1 = new Select(dropedown);


            dr1.selectByIndex(counter);


            driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();


            System.out.println(driver.getTitle());

//            driver.navigate().back();
            counter++;



        } while (counter != 6);

    }
}



