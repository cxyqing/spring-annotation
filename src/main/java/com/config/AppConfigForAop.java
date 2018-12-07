package com.config;

import com.aop.Calculator;
import com.aop.CalculatorImpl;
import com.aop.LogAspects;
import com.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AppConfigForAop {

    @Bean
    public MathCalculator mathCalculator(){
        MathCalculator mathCalculator = new MathCalculator();
        return mathCalculator;
    }

    @Bean
    public Calculator calculator(){
        Calculator calculator = new CalculatorImpl();
        return calculator;
    }

    @Bean
    public LogAspects logAspects(){
        LogAspects logAspects = new LogAspects();
        return logAspects;
    }
}
