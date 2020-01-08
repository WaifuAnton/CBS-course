package task2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @Pointcut("execution(* *(..))")
    private void all() { }

    @AfterThrowing(value = "all()", throwing = "e")
    public void afterThrowingAdvice(JoinPoint jp, Throwable e) {
        System.out.println("Method signature - " + jp.getSignature());
        System.out.println("Error - " + e);
    }
}
