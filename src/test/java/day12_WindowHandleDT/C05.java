package day12_WindowHandleDT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C05 extends TestBase {




    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("http://www.amazon.com/");
        Set<Cookie> allCookies = driver.manage().getCookies();
//2-tum cookie'leri listeleyin
        for (Cookie cookie : allCookies) {
            System.out.println(cookie.getName() + " " + cookie.getValue());
        }
//3-sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
       int allCookSize = allCookies.size();
        System.out.println("allCookSize = " + allCookSize);
        Assert.assertTrue(allCookies.size() > 5);

//4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
       String cookieValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
       assertEquals("USD", cookieValue);


//5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin
      Cookie newCookie=  new Cookie("en sevdigim cookie", "cikolatali");
      driver.manage().addCookie(newCookie);
        System.out.println(driver.manage().getCookies().size());
//6-eklediginiz cookie'nin sayfaya eklendigini test edin

//        6-eklediginiz cookie'nin sayfaya eklendigini test edin
        String yeniCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        assertEquals("cikolatali", yeniCookieValue);

//        7-ismi skin olan cookie'yi silin ve silindigini test edin
        int cookieSilinmedenOnce = driver.manage().getCookies().size();
        driver.manage().deleteCookieNamed("skin");
        int cookieSilindiktenSonra = driver.manage().getCookies().size();
        assertEquals(1, (cookieSilinmedenOnce - cookieSilindiktenSonra));

//        8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        assertEquals(0, driver.manage().getCookies().size());

    }
}
