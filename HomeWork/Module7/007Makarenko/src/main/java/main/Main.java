package main;

import entity.Author;
import entity.MP3;
import helper.AuthorHelper;
import helper.MP3Helper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AuthorHelper authorHelper = (AuthorHelper) context.getBean("authorHelper");
        MP3Helper mp3Helper = (MP3Helper) context.getBean("mp3Helper");
        Map<String, Integer> map = authorHelper.groupByNames();
        System.out.println(map);
    }
}
