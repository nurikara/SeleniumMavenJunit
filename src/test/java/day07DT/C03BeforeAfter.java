package day07DT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03BeforeAfter {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test01() throws InterruptedException {

        driver.get("htpps://techproeducation.com");
        Thread.sleep(3000);
    }

    @Test

    public void test02() throws InterruptedException {

        driver.get("htpps://google.com");


    }

    @After

    public void tearDown() throws InterruptedException {

        driver.close();
    }


}
