package one.jkr.de.jkrprojects.jkrprojects.rest.app.systems.email.management.system.spring.config;


import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class AwsSesSpringConfiguration {

    @Bean
    public AmazonSimpleEmailService amazonSes() {
        return AmazonSimpleEmailServiceAsyncClient
                .asyncBuilder()
                .withRegion(Regions.EU_CENTRAL_1)
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .build();
    }

}
