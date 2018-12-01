package com.ex;

import com.config.AppConfigForLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class IOCTestForLifeCycle {
    private AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfigForLifeCycle.class);

    @Test
    public void test01(){
        printBeanDefinitionNames();

        cxt.close();
    }

    public void printBeanDefinitionNames(){
        Arrays.stream(cxt.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
