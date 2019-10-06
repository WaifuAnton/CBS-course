package task2_reflec;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name (Class1 or Class2): ");
        String className = scanner.next();
        String classNameFull = "task2_reflec." + className;
        classInfo(classNameFull);
    }

    static void classInfo(String className) {
        try {
            Class classInfo = Class.forName(className);
            Method[] methods = classInfo.getDeclaredMethods();
            Field[] fields = classInfo.getDeclaredFields();
            Constructor[] constructors = classInfo.getDeclaredConstructors();
            for (Method method : methods) {
                System.out.println("Method name: " + method.getName());
                Parameter[] parameters = method.getParameters();
                System.out.print("Parameters: ");
                for (Parameter parameter : parameters)
                    System.out.println(parameter.getType() + " ");
                System.out.println();
            }
            int i = 0;
            for (Constructor constructor : constructors) {
                System.out.println("Constructor #: " + i);
                Parameter[] parameters = constructor.getParameters();
                System.out.print("Parameters: ");
                for (Parameter parameter : parameters)
                    System.out.println(parameter.getType() + " ");
                System.out.println();
            }
            for (Field field : fields) {
                System.out.println("Fields: " + field.getType() + " ");
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("Wrong name of class");
        }
    }
}
