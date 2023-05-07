package day09_actionClass;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C08_FakerClass {
    @Test
    public void test01(){
        // Faker is a library. First copy the dependency from Maven into the pom.xml

        Faker faker = new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().fullName());

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.internet().password());
        System.out.println(faker.gameOfThrones().house());
        System.out.println(faker.gameOfThrones().dragon());
    }
}
