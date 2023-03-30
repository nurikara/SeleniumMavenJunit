package day07JunitNT;

import org.junit.*;

public class C04_BeforeClasAfterClas {

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Clastaki tum testlrden once bir kere calisir");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Clastan sonra bir kere calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her testten once calsir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her bir testten sonra calisir");
    }

    @Test
    public void test01() {

        System.out.println("1. test");
    }

    @Test
    public void test02() {

        System.out.println("2. test");
    }
}
