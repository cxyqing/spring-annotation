package com.config;

import com.ex.bean.Employee;
import com.ex.bean.School;
import com.ex.bean.Student;
import com.ex.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(value = {"com.ex.dao","com.ex.service","com.ex.bean"})
public class AppConfigForAutowired {
    @Primary
    @Bean
    public BookDao bookDao2(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

    @Bean("school2")
    public School school(Employee employee, Student student){
        School school = new School(employee,student);

        return school;
    }
    @Bean("school3")
    public School school3(Employee employee, Student student){
//        School school = new School(employee,student);

        return school(employee,student);
    }
}
