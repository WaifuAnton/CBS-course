package t45;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("t45.xml");
        ModelT1000 T1000 = (ModelT1000) context.getBean("T1000");
        T1000.action();
    }
}
