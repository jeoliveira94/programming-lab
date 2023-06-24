package aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private static final Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment){
        logger.info("Publishing comment: " + comment.getText());
        return "PUBLISHED";
    }

    public String deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
        return "DELETED";
    }

    public String updateComment(Comment comment) throws Exception {
        logger.info("Updating comment: " + comment.getText());
        throw new Exception("Failed to update comment: " + comment.getText());
    }
}
