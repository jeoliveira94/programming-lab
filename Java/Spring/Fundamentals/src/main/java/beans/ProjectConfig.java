package beans;

import beans.models.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "beans.models")
public class ProjectConfig {

    @Bean
    Parrot parrot1() {
        return new Parrot("Miki");
    }

    @Bean
    Parrot parrot2() {
        return new Parrot("Jorge");
    }

    @Bean
    Lion lion() {
        return new Lion("Simba");
    }

    @Bean
    Person person() {
        Person person = new Person(lion());
        return person;
    }
}
