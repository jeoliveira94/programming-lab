package beans.models;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;

    public Person() {
        this.name = "José Oliveira";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
