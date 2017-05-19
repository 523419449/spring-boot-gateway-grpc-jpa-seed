package an.royal.gateway.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by carl.huang on 12/05/2017.
 */
@SpringBootApplication(scanBasePackages = "an.royal.gateway")
@EnableAutoConfiguration
@EnableConfigurationProperties
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
