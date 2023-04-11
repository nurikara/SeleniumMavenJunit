package day14_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02 extends TestBase    {
    @Test
    public void test01() {
        Faker faker = new Faker();

        System.out.println(Faker.instance().name().firstName());
        System.out.println(Faker.instance().name().firstName());

        System.out.println(faker.job().position());

        System.out.println(faker.color().name());

        System.out.println(faker.internet().emailAddress());
    }
}
