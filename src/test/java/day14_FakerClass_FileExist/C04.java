package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04 extends TestBase {
    @Test
   public void test01() {

//        "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
     File sil = new File("C:\\Users\\nurik\\Downloads\\b10 all test cases, code.docx");
     sil.delete();
//        "b10 all test cases" dosyasını indirin
        driver.findElement(By.xpath("(//a)[3]")).click();
        wait(3);
//        Dosyanın başarıyla indirilip indirilmediğini test edin.
//"C:\Users\nurik\Downloads\b10 all test cases, code.docx"
        //"C:\Users\nurik/Downloads/b10 all test cases,code.docx"
        String dosyayolu = System.getProperty("user.home")+"\\Downloads\\b10 all test cases, code.docx";



        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));



    }

 }
