package com.ex;

import com.config.AppConfigForPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class IOCTestForPropertyValue {
    private AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfigForPropertyValue.class);

    @Test
    public void test01(){
        printBeanDefinitionNames();
        System.out.println(cxt.getBean("person"));
        cxt.close();
    }

    public void printBeanDefinitionNames(){
        Arrays.stream(cxt.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
