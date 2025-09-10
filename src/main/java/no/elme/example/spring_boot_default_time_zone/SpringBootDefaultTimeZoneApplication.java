package no.elme.example.spring_boot_default_time_zone;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringBootDefaultTimeZoneApplication {

    public static void main(String[] args) {
//        If the time zone is set here it's not picked up in Spring Boot test
//        TimeZone.setDefault(TimeZone.getTimeZone("Antarctica/South_Pole"));

        SpringApplication.run(SpringBootDefaultTimeZoneApplication.class, args);
    }

    @PostConstruct
    public void setDefaultTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Antarctica/South_Pole"));
    }

}
