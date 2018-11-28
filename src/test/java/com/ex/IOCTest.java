package com.ex;

import com.config.AppConfig;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class IOCTest {



    @Test
    public void test02(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        BeanDefinition beanDefinition = ctx.getBeanDefinition("person");
        System.out.println("FactoryMethodName: " + beanDefinition.getFactoryMethodName());
    }
    @Test
    public void test01(){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("com/ex/beans.xml");
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
