package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will execute");

        Object[] originalArgs = joinPoint.getArgs();
        logger.info("Original args: " + Arrays.asList(originalArgs));

        Comment comment = new Comment("José Oliveira", "Aspects allow you to change PointCut's parameters and returns.");
        Object[] newArgs = {comment};
        logger.info("New args: " + Arrays.asList(newArgs));

        Object returnedByMethod = joinPoint.proceed(newArgs);
        logger.info("Method executed and returns: " + returnedByMethod);

        return "Changed by aspect";
    }

    @AfterReturning(value = "(execution(* CommentService.deleteComment(..)))", returning = "returnedValue")
    public Object logAfter(Object returnedValue) {
        logger.info("Method executed and returns: " + returnedValue);
        return returnedValue;
    }

    @AfterThrowing(pointcut = "(execution(* CommentService.updateComment(..)))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.severe("Method " + joinPoint.getSignature().getName() + " throws an exception " + exception.getMessage());
    }
}
