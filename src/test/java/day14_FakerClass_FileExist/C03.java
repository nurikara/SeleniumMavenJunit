package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03 extends TestBase {

    @Test
    public void test01() {
        //Masaüstünde bir dosya oluşturalım
        //Bu dosyanın varlığını doğrulayalım
        System.out.println(System.getProperty("user.dir"));//C:\Selenium\B129SeleniumMavenJunit
        //Projemizin içinde bulunduğu yolu verir
        System.out.println(System.getProperty("user.home"));//C:\Users\Lenovo
        //Localimizdeki kullanıcı yolunu verir
        //String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\b129.txt";
        String farkliKisim = System.getProperty("user.home");//Her kullanıcının ana yolu farklı olduğuğu için farklı kısım dedik
        String ortakKisim = "\\OneDrive\\Masaüstü\\b129.txt";//Aynı yerde oluşturulduğu için ortakKısım dedik
        String dosyaYolu = farkliKisim+ortakKisim;//Dosya yolu olarak farkliKisim ve ortakkisimi aldık
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); //Files.exists methodu ile dosyanın varlığını doğruladık
    }
}
