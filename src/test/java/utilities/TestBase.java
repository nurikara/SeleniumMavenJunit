package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestBase {

    protected static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
//        Thread.sleep(3000);
//        driver.quit();
    }

    public static void wait(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert accept
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public static void alertGetText() {

        driver.switchTo().alert().getText();
    }

    public static void alertPrompt(String text) {

        driver.switchTo().alert().sendKeys(text);
    }

    public static void ddmVisibletext(WebElement ddm,String option) {

        Select select = new Select(ddm);

        select.selectByVisibleText(option);
    }

    public static void switchToWindow(int i) {
        List<String> windowHL = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHL.get(i));

    }

    //SwitchToWindow2
    public static void window(int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }




}
