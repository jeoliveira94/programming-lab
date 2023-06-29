package beans;

import beans.models.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get different beans of the same class with name
        Parrot parrot1 = context.getBean("parrot1", Parrot.class);
        Parrot parrot2 = context.getBean("parrot2", Parrot.class);

        logger.info(parrot1.getName());
        logger.info(parrot2.getName());

        // Adding beans programmatically
        Turtle turtle = new Turtle();
        turtle.setName("Pedro");
        Supplier<Turtle> supplier = () -> turtle;
        context.registerBean("turtle", Turtle.class, supplier);
        Turtle turtleBean = context.getBean(Turtle.class);
        logger.info(turtleBean.getName());


        Person person = context.getBean(Person.class);
        logger.info(person.toString());


    }
}
