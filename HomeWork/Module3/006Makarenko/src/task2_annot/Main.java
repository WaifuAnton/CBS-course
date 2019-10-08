package task2_annot;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Class calcClass = calculator.getClass();
        Method[] methods = calcClass.getMethods();
        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Math.class)) {
                    Math math = method.getAnnotation(Math.class);
                    System.out.println(method.invoke(calculator, math.left(), math.right()));
                }
            }
        }
        catch (InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
