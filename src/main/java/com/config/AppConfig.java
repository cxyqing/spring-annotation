package com.config;


import com.ex.bean.Person;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScans({@ComponentScan(basePackages = {"com.ex"},includeFilters = {@ComponentScan.Filter(type=FilterType.CUSTOM, value ={MyFilterType.class} )})})
public class AppConfig {

    @Bean
    public Person person(){

        return new Person("James",30);
    }
}
