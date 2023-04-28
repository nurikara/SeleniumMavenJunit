package Odevler;

import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Odev_12 extends TestBase {

    @Test
    public void test01() {
        Workbook workbook = new XSSFWorkbook();
        // Yeni bir çalışma sayfası oluştur
        Sheet sheet = workbook.createSheet("Sayfa1");

        //-Birinci satır birinci hücreye email ve ikinci hücreye password

        Row row = sheet.createRow(0);

        // Yeni bir hücre oluştur ve "email" yaz
        Cell cell = row.createCell(0);
        cell.setCellValue("email");

        // Yeni bir hücre oluştur ve "password" yaz
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("password");
        // -ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım

        Row row1 = sheet.createRow(1);

        // Yeni bir hücre oluştur ve "email" yaz
        Cell cell2 = row1.createCell(0);
        cell2.setCellValue("evren.techproed@gmail.com");

        // Yeni bir hücre oluştur ve "password" yaz
        Cell cell3 = row1.createCell(1);
        cell3.setCellValue("asdfgh");

        //-Dosyayı kaydedelim


        // Dosyayı kaydet
        try (

                FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.home") + "/Desktop/data1.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() throws IOException {

        //İkinci methodda https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com");

        //        -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/data1.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String email = workbook.getSheet("Sayfa1").getRow(1).getCell(0).toString();
        String password = workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString();

        driver.findElement(By.xpath("//a[@role=\"button\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        // -Login olduğumuzu doğrulayalım
        String login = driver.findElement(By.id("dropdown-basic-button")).getText();
        System.out.println("login = " + login);
        Assert.assertEquals(login,"Erol Evren");






    }
}

