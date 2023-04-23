package practice06DT;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02 extends TestBase {

    @Test
    public void test01() {
        // Desktop(masaustu)'da bir text dosyası olusturun
        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        String farkliKIsim=System.getProperty("user.home");
        System.out.println(farkliKIsim);

        String ayniKisim= "\\Desktop\\Text.txt";

        String ortakAdres= "ayniKisim+farkliKisim";
        Assert.assertTrue(Files.exists(Paths.get(ortakAdres)));
    }
}
