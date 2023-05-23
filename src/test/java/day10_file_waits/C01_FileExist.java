package day10_file_waits;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        //the path of my desktop file that I created manually
        //"C:\Users\fatih\Desktop\Java-Selenium\FileTest\demo.txt"

        /*
            System.getProperty("user.home") gives the path to the user on all computers.
            This part is different for each computer and each user.
            However, it can be common for all users after user.home.
            For example all users desktop is user.home/desktop
            If you are going to test the file on more than one computer, you need to create the file path dynamically.
         */

        // we created first Java-Selenium folder on desktop, then FileTest folder inside Java-Selenium
        // then demo.txt inside FileTest

        String dynamicFilePath = System.getProperty("user.home")+"\\Desktop\\Java-Selenium\\FileTest\\demo.txt";

        System.out.println(Files.exists(Paths.get("the path that we want to reach"))); // false
        System.out.println(Files.exists(Paths.get(dynamicFilePath))); // true
    }
}
