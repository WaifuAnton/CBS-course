package t45;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class T1000Replacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("T1000 is too dead to attack");
        return o;
    }
}
