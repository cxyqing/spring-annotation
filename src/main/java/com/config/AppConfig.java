package com.config;


import com.ex.bean.Person;
import com.ex.dao.BookDao;
import com.ex.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScans({@ComponentScan(basePackages = {"com.ex"},includeFilters =
        {@ComponentScan.Filter(type=FilterType.CUSTOM, value ={MyFilterType.class})
                ,@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})
                ,@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = BookDao.class)},useDefaultFilters = false)})
public class AppConfig {

    @Lazy
    @Scope("singleton")
    @Bean
    public Person person(){

        return new Person("James",30);
    }
}
