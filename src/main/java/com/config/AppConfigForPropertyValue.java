package com.config;

import com.beanpostprocessor.MyBeanPostProcessor;
import com.ex.bean.Car;
import com.ex.bean.Person;
import org.springframework.context.annotation.*;

@PropertySource({"classpath:/com/ex/person.properties"})
@Configuration
//@ComponentScan(basePackages = {"com.beanpostprocessor"},includeFilters =
//        {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {MyBeanPostProcessor.class})},useDefaultFilters = false)
public class AppConfigForPropertyValue {

    @Bean
    public Person person(){
        return new Person();
    }

}
