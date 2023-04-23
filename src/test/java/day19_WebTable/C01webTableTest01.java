package day19_WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;

public class C01webTableTest01 extends TestBase {

    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("((//table)[1]/tbody//tr)[1]"));
        System.out.println("table");
        System.out.println(table1.getText());

        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");
        //    Task 2 : 3. Satır verilerini yazdırın

        //    Task 2 : 3. Satır verilerini yazdırın
        //1.Yol
        WebElement satir3 = driver.findElement(By.xpath("(//tbody)[1]//tr[3]"));
        System.out.println("3. Satir Bilgileri");
        System.out.println(Arrays.toString(satir3.getText().split(" ")));
        System.out.println(satir3.getText());
        //2.Yol
        List<WebElement> list = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td"));
        list.forEach(t-> System.out.print(t.getText()+" - "));
        //    Task 3 : Son satırın verilerini yazdırın
        WebElement lastRow = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));

        System.out.println(Arrays.toString(lastRow.getText().split("")));

        //    Task 4 : 5. Sütun verilerini yazdırın
        driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
       List<WebElement> stunlist= driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
       stunlist.forEach(t-> System.out.println(t.getText()));



    }
    //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
    //    Parameter 1 = satır numarası
    //    Parameter 2 = sütun numarası
    //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

    @Test
    public void webTablesTest2() {
        driver.get("https://the-internet.herokuapp.com/tables");
        printData(2,3);
        printData(2,5);
        printData(3,2);
        printData(1,4);
        //printData(1,7);--> 7. sütun olmadığı için NoSuchElementException hatası alırız
    }
    public void printData(int satir, int sutun){
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }


}

