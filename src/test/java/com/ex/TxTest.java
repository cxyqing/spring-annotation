package com.ex;

import com.tx.AppConfigForTx;
import com.tx.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

public class TxTest {
    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigForTx.class);

    @Test
    public void test02(){
        PersonService personService = ctx.getBean(PersonService.class);
        personService.add();
    }
    @Test
    public void test01(){
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}
