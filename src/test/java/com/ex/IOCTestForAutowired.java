package com.ex;

import com.config.AppConfigForAutowired;
import com.ex.dao.BookDao;
import com.ex.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTestForAutowired {
    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigForAutowired.class);

    @Test
    public void test02(){
        System.out.println(ctx.getBean("school"));
        System.out.println(ctx.getBean("school2"));
        System.out.println(ctx.getBean("school3"));
    }
    @Test
    public void test01(){
        System.out.println(ctx.getBean(BookService.class));
//        System.out.println(ctx.getBean("bookDao"));
        ctx.getBeansOfType(BookDao.class).forEach((k,v)->System.out.println(k + " = " + v));
    }
}
