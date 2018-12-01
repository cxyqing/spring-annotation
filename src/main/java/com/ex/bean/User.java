package com.ex.bean;

import com.condition.UserCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

//@Conditional({UserCondition.class})
@Component
public class User {

    private String name;

    private int age;
    public User(){}
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
