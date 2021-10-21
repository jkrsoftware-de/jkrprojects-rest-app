package one.jkr.de.jkrprojects.jkrprojects.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JkrProjectsRestApp {

    public static void main(String[] args) {
        SpringApplication.run(JkrProjectsRestApp.class, args);
    }

}
