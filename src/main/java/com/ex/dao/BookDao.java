package com.ex.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Primary
@Repository
public class BookDao {
    private String lable = "one";

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
