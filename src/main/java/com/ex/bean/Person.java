package com.ex.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    @Value("James")
    private String name;
    private int age;
    private String nickName;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person's Constructor...");
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    @Value("#{20 + 2}")
    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }
    @Value("${person.nickName}")
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
