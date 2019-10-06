import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Class calcClass = calculator.getClass();
        Method[] methods = calcClass.getMethods();
        try {
            //Method method = calcClass.getMethod("add", new Class[] {int.class, int.class});
            {
                for (Method method : methods)
                {
                    if (method.isAnnotationPresent(Math.class))
                    {
                        Math math = method.getAnnotation(Math.class);
                        int result = (int) method.invoke(calculator, math.left(), math.right());
                        System.out.println(result);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
