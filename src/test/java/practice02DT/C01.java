package practice02DT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
       WebElement searchbBox = driver.findElement(By.xpath("//input[@type='text']"));

       String actualTagname = searchbBox.getTagName();

       String expectedTagname = "input";

       if(actualTagname.equals(expectedTagname)){

           System.out.println("Test PASSED");
       }else System.out.println("Test FAILED");

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin

        String actualAttribute = searchbBox.getAttribute("name");
        String expectedAttribute ="field-keywords";

        if(actualTagname.equals(expectedTagname)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED ");

        // sayfayi kapatiniz"
    }
}
