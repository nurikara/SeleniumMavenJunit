package Odevler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

public class Odev_11task extends TestBase {
    @Test
    public void test01() throws IOException {


        //Açılan pencerede chromedriver'i indirelim
        //Driver'in indiğini doğrulayalım
        //İndirmiş olduğumuz dosyayı silelim
        //Silindiğini doğrulayalım
        //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)
//        extentTest=extentReports.createTest("ExtentTest","Test Raporu");

//        extentTest = extentReports.createTest("ExtentTest", "Test Raporu");
    //    ExtentTest test = extentReports.createTest("Nuri", "task10");
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads");
        extentTest.info("Belirtilen adrese gidildi");
        //Sayfanın resmini alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot" + tarih + ".png";
        extentTest.info("Sayfanin resmi alindi");
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));


        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement(By.xpath("//h2[@class='card-title pb-4']"))).perform();
        extentTest.info("Browsers bölümü görünene kadar sayfayı indirelim");
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım

        WebElement browser = driver.findElement(By.xpath("//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left']"));
        browser.click();
        extentTest.info("Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım");
        driver.findElement(By.xpath("//a[@href='https://chromedriver.chromium.org/']")).click();

        //Documentation webelementinin resmini alalım


        WebElement Wb = driver.findElement(By.xpath("//span[text()='ChromeDriver Documentation']"));

        FileUtils.copyFile(Wb.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        String homeWH = driver.getWindowHandle();
        System.out.println("homeWH = " + homeWH);

        extentTest.info("Documentation webelementinin resmini alalım");

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//span[@class='C9DxTc aw5Odc '])[2]")).click();
        wait(3);
        extentTest.info("All versions available in Downloads altında Latest stable release olan linki tıklayalım");
        //Açılan pencerede chromedriver'i indirelim
        extentTest.info("Açılan pencerede chromedriver'i indirelim");

        Set<String> tumPencereler = driver.getWindowHandles();
        System.out.println("tumPencereler = " + tumPencereler);

        for (String w : tumPencereler) {
            if (!w.equals(homeWH)) {

                driver.switchTo().window(w);
                System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

                WebElement satir3 = driver.findElement(By.xpath("//a[@href='/112.0.5615.49/chromedriver_win32.zip']"));
                satir3.click();

            }
        }




//        WebElement download = driver.findElement(By.xpath("//*[@href='/112.0.5615.49/chromedriver_win32.zip']"));
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(download));
//
//        download.click();


    }


//        String ortak = "\\chromedriver_win32 (1).zip";
//        String ozel = "Users.home";
//
//        String dosyaYolu1 = "ortak+ozel";
//
//        System.out.println("dosyaYolu1 = " + dosyaYolu1);

}

