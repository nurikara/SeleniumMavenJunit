package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    /*
1)https://amazon.com adresine gidin
2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
*/
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void afterClass() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void titleTest() {
       // ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void imageTest() throws InterruptedException {
       // ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin

        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));

        Assert.assertTrue(logo.isDisplayed());

        Thread.sleep(3000);

    }

    @Test
    public void searchBox() {
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())

        WebElement searchBox = driver.findElement(By.xpath("//label[@for='twotabsearchtextbox']"));

        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        Assert.assertFalse(driver.getTitle().contains("amazon"));


    }
}
