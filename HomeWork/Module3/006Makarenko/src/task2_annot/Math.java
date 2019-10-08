package task2_annot;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Math {
    double left() default 10;
    double right() default 20;
}
