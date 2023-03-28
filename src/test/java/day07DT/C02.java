package day07DT;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class C02 {

    @Before
    public void setup() {

        System.out.println("Her test oncesi bir kere calisir");
    }
@After
    public void tearDown() {

        System.out.println("Her test SONRASI bir kere calisir");
    }


    @Test
    public void test01() {

        System.out.println("ilk Test methodu");
    }

    @Test
    public void test02() {

        System.out.println("ikinci Test methodu");
    }
}
