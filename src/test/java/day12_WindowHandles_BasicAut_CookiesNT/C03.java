package day12_WindowHandles_BasicAut_CookiesNT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03 extends TestBase {

    @Test
    public void test01() {

//    1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
//    2-tum cookie’leri listeleyin
       Set<Cookie> cookies = driver.manage().getCookies();
       int beforeCookies = cookies.size();

       for (Cookie cookie : cookies) {
           System.out.println(cookie.getName() + " : " + cookie.getValue());
       }

//    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int countCookie = cookies.size();
        Assert.assertTrue(countCookie>5);
//    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Assert.assertTrue(cookies.stream().anyMatch(cookie -> cookie.getName().equals("i18n-prefs") && cookie.getValue().equals("USD")));
//    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("ensevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        cookies = driver.manage().getCookies();
       int aftercountCookie = cookies.size();
       Assert.assertTrue(aftercountCookie>beforeCookies);

//

//    7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookies.contains("skin"));
//    8-tum cookie’leri silin ve silindigini test edin
        for (Cookie cookie1 : cookies) {
            System.out.println(cookie1.getName() + " : " + cookie1.getValue());
        }


    }
}
