package task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context2.xml");
        Calc calc = (Calc) context.getBean("calc");
        System.out.println(calc.div(1, 0));
    }
}
