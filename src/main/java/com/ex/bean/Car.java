package com.ex.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements InitializingBean, DisposableBean {

    public Car(){
        System.out.println("Car...Constructor...");
    }

    public void  init(){
        System.out.println("Car...init...");
    }

    public void  destroyMethod(){
        System.out.println("Car...destroyMethod...");
    }
    @PostConstruct
    public void postConstructor(){
        System.out.println("Car...postConstructor...");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("Car...preDestroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car...afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Car...destroy...");
    }
}
