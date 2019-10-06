package task3_reflec;

import java.lang.reflect.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name (Class1 or Class2): ");
        String className = scanner.next();
        className = "task3_reflec." + className;
        classInfo(className);
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
                int mod = constructor.getModifiers();
                if (Modifier.isPrivate(mod))
                    System.out.print("private ");
                else if (Modifier.isPublic(mod))
                    System.out.print("public ");
                if (Modifier.isAbstract(mod))
                    System.out.print("abstract ");
                if (Modifier.isFinal(mod))
                    System.out.print("final ");
                System.out.println("constructor #: " + i);
                Parameter[] parameters = constructor.getParameters();
                System.out.println("Parameters: ");
                for (Parameter parameter : parameters) {
                    mod = constructor.getModifiers();
                    if (Modifier.isPrivate(mod))
                        System.out.print("private ");
                    else if (Modifier.isPublic(mod))
                        System.out.print("public ");
                    if (Modifier.isAbstract(mod))
                        System.out.print("abstract ");
                    if (Modifier.isFinal(mod))
                        System.out.print("final ");
                    System.out.println(parameter.getType() + " ");
                }
                System.out.println();
            }
            System.out.println("Fields: ");
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isPrivate(mod))
                    System.out.print("private ");
                else if (Modifier.isPublic(mod))
                    System.out.print("public ");
                else if (Modifier.isProtected(mod))
                    System.out.print("protected ");
                if (Modifier.isAbstract(mod))
                    System.out.print("abstract ");
                if (Modifier.isFinal(mod))
                    System.out.print("final ");
                System.out.println(field.getType() + " ");
            }
        }
        catch (ClassNotFoundException e) {
            System.out.println("Wrong name of class");
        }
    }
}
