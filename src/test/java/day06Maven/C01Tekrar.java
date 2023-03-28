package day06Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01Tekrar {
    public static void main(String[] args) {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //        https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

//        arama kutusunu locate edelim


//        “Samsung headphones” ile arama yapalim
//        Bulunan sonuc sayisini yazdiralim
//        Ilk urunu tiklayalim
//        Sayfadaki tum basliklari yazdiralim
    }
}
