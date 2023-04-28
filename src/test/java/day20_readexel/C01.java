package day20_readexel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01 {

     /*
Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
Kullanılan satır sayısın bulun
Ülke-Başkent şeklinde verileri yazdırın
 */

    @Test
    public void readExelTest() throws IOException {
        //        dosyayi Al;

        FileInputStream fileInputStream = new FileInputStream("src/test/java/resourses/Capitals (2).xlsx");
        //FileOutputStream objesini WorkBook(Exel) dosyasi olarak ac;

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Sayfayi(sheet) ac
        Sheet sheet1 = workbook.getSheet("sheet1");

        // Satira(Row) git;
        Row row = sheet1.getRow(0);


        // Birinci hucreyi(Cell) al
        Cell cell = row.getCell(0);
        System.out.println("cell = " + cell);

        //        Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell12 = sheet1.getRow(0).getCell(1);

        System.out.println("cell12 = " + cell12);


//        3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        Cell cell31 = sheet1.getRow(2).getCell(0);
        System.out.println("cell31 = " + cell31);
        Assert.assertEquals("France", cell31.toString());

//        Kullanılan satır sayısın bulun
        int sonkullanilanSatirIndex= sheet1.getLastRowNum();
        System.out.println("sonkullanilanSatirIndex = " + sonkullanilanSatirIndex);


      int kullanilanToplamSatirSayisi =  sheet1.getPhysicalNumberOfRows();

        System.out.println("kullanilanToplamSatirSayisi = " + kullanilanToplamSatirSayisi);



        //        Ülke-Başkent şeklinde verileri yazdırın

        Map<String, String> ulkelerVeBaskentleri = new HashMap<>();

        for (int satirIndeks = 1; satirIndeks < kullanilanToplamSatirSayisi; satirIndeks++) {

            String ulkeAdi = sheet1.getRow(satirIndeks).getCell(0).toString();
            String baskentAdi = sheet1.getRow(satirIndeks).getCell(1).toString();

            ulkelerVeBaskentleri.put(ulkeAdi, baskentAdi);

        }
}}
