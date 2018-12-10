package com.ext;

import com.ex.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.ext"})
@Configuration
public class AppConfigForExt {


    @Bean
    public Person person(){
        return new Person("Jerry",18);
    }

}
