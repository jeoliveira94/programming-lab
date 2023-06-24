package aspects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("José Oliveira");
        comment.setText("Learning about Aspects!!!");

        var commentService = context.getBean(CommentService.class);
        Object returnedByMethod = commentService.deleteComment(comment);
        logger.info("Returned by method in main: " + returnedByMethod);
    }
}
