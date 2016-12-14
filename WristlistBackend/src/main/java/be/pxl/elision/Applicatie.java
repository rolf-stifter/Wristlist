package be.pxl.elision;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.TimeZone;

/**
 * Created by 11308157 on 1/12/2016.
 */
@ComponentScan
@EnableScheduling
@Configuration
@SpringBootApplication
public class Applicatie{


    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(Applicatie.class, args);
    }


}
