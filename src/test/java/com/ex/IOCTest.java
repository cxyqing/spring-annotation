package com.ex;

import com.config.AppConfig;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

public class IOCTest {



    @Test
    public void test02(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.scan("com.ex");
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        BeanDefinition beanDefinition = ctx.getBeanDefinition("person");
        System.out.println("FactoryMethodName: " + beanDefinition.getFactoryMethodName());
    }
    @Test
    public void test01(){
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("com/ex/beans.xml");
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
    @Test
    public void testUrl() throws IOException {
        Enumeration<URL> resources = this.getClass().getClassLoader().getResources("com/ex");
        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            System.out.println(url.getFile());
        }
    }
}
