package day07DT;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class C04BeforeClassAfterClass {

    @BeforeClass
    public static void setup(){

        System.out.println("Tum testlerden once birkez calisir");

        System.out.println("======================");

    }
    @Test

    public void test01(){
        System.out.println("Ilk test");
        System.out.println("===========");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci test");
        System.out.println("===========");
    }
@Test
    public void test03(){
        System.out.println("ucuncu test");
        System.out.println("===========");
    }

    @Before
    public void setup2(){
        System.out.println("Her Testten sonra calisir");
    }
    @AfterClass

    public void kapat(){

        System.out.println("Kalasyan sonra");



    }
}
