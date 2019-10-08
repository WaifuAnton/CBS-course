package task3_annot;

import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) {
        Class[] myClasses = { ClassA.class, ClassB.class, ClassC.class };
        for (Class cl : myClasses) {
            if (cl.isAnnotationPresent(ClassDescription.class)) {
                System.out.println("Class " + cl + " has annotation " + ClassDescription.class);
            }
        }
    }
}
