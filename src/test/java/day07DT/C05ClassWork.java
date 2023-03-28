package day07DT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05ClassWork {
    WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After

    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test

    public void test01(){
        //    a.Verilen web sayfasına gidin.
        driver.get("https://the-internet.herokuapp.com/checkboxes");
//    https://the-internet.herokuapp.com/checkboxes
//    b.Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement Checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement Checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
//    c.Checkbox1 seçili değilse onay kutusunu tıklayın
        if(!Checkbox1.isSelected()){
            Checkbox1.click();
        }
//    d.Checkbox2 seçili değilse onay kutusunu tıklayın

        if(!Checkbox2.isSelected()){
            Checkbox2.click();
        }

    }





}
