package com.ex;

import com.ex.bean.Person;
import com.ext.AppConfigForExt;
import com.ext.MyApplicationEvent;
import com.tx.AppConfigForTx;
import com.tx.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class ExtTest {
    private AnnotationConfigApplicationContext ctx;


    @Test
    public void test01(){
        ctx = new AnnotationConfigApplicationContext(AppConfigForExt.class);
        ctx.publishEvent(new MyApplicationEvent(new Person("James",28)));
        ctx.close();
    }
}
