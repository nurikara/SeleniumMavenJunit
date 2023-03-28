package day06Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Odev1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //        “https://www.saucedemo.com” Adresine gidin

        driver.get("https://www.saucedemo.com");
//        Username kutusuna “standard_user” yazdirin
        WebElement userName = driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]"));

       userName.sendKeys("standard_user", Keys.ENTER);
//        Password kutusuna “secret_sauce” yazdirin
        WebElement password = driver.findElement(with(By.tagName("input")).below(userName));

        password.sendKeys("secret_sauce");
//        Login tusuna basin

        WebElement login =driver.findElement(By.cssSelector("input[name='login-button']"));
        login.click();
          Thread.sleep(3000);
//        Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urun1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

        String u1 = urun1.getText();
        System.out.println("1. urun "+u1);

        urun1.click();

//        Add to Cart butonuna basin

        WebElement addCard = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));

        addCard.click();
//        Alisveris sepetine tiklayin
        WebElement sepet = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();
//        Sectiginiz urunun basarili olarak sepete eklendigini control edin

        WebElement urunKontrol = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

     boolean valid = urunKontrol.isDisplayed();

     if(valid)
         System.out.println("Test Passed");
     else
         System.out.println("Test Failed");

//        Sayfayi kapatin
        driver.close();
    }
}
