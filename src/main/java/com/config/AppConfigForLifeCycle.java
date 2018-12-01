package com.config;

import com.beanpostprocessor.MyBeanPostProcessor;
import com.ex.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.beanpostprocessor"},includeFilters =
        {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {MyBeanPostProcessor.class})},useDefaultFilters = false)
public class AppConfigForLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroyMethod")
    public Car car(){
        return new Car();
    }

}
