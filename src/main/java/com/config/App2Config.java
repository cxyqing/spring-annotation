package com.config;

import com.condition.UserCondition;
import com.ex.bean.Department;
import com.ex.bean.DepartmentFactoryBean;
import com.ex.bean.Employee;
import com.ex.bean.User;
import com.imports.MyImportBeanDefinitionRegistrar;
import com.imports.MyImportSelector;
import org.springframework.context.annotation.*;

//@Conditional({UserCondition.class})
@Configuration
@ComponentScan(basePackages = {"com.ex.bean"})
@Import({MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class App2Config {

    @Conditional({UserCondition.class})
    @Bean("LinChong")
    public User user(){
        return new User("LinChong",30);
    }


    @Bean("LiKui")
    public User user2(){
        return new User("LiKui",30);
    }

    @Bean
    public DepartmentFactoryBean department(){
        return new DepartmentFactoryBean();
    }
}
