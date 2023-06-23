package aspects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aspects {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("José Oliveira");
        comment.setText("Learning about Aspects!!!");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
