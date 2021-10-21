package one.jkr.de.jkrprojects.jkrprojects.rest.app.general.configurations;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootConfiguration
public class SpringConfiguration {

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

}
