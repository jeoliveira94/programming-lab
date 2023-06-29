package beans.models;

import beans.Lion;
import beans.Parrot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name;
    private final Lion lion;

    @Autowired
    public Person(Lion lion) {
        this.lion = lion;
        this.name = "José Oliveira";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lion getLion() {
        return lion;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lion=" + lion +
                '}';
    }
}
