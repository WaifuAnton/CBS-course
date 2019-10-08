package task3_annot;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

@Inherited
@Documented
public @interface ClassDescription {
    String author() default "N/A";
    String lastModified() default "N/A";
    String version() default "N/A";
}
