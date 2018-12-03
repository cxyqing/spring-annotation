package com.ex.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
    private Student student;
    private Employee employee;
//    public School(){}
    @Autowired
    public  School(Student student){
        this.student = student;
    }
    public School(Employee employee,Student student){
        this.student = student;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "School{" +
                "student=" + student +
                ", employee=" + employee +
                '}';
    }
}
