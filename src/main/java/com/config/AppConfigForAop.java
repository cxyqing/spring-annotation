package com.config;

import com.aop.Calculator;
import com.aop.CalculatorImpl;
import com.aop.LogAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AppConfigForAop {

    @Bean
    public Calculator calculator(){

        return new CalculatorImpl();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
