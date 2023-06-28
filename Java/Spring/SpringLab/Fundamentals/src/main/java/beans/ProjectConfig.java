package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot1() {
        return new Parrot("Miki");
    }

    @Bean
    Parrot parrot2() {
        return new Parrot("Jorge");
    }
}
