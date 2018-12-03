package com.ex;

import com.config.AppConfigForProfile;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;
import java.util.Arrays;

public class IOCTestForProfile {
    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

    @Before
    public void init(){
        ctx.getEnvironment().setActiveProfiles("test","dev");
        ctx.register(AppConfigForProfile.class);
        ctx.refresh();
    }
    @Test
    public void test01(){
        ConfigurableEnvironment environment = ctx.getEnvironment();
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        ctx.getBeansOfType(DataSource.class).forEach((k,v)->{System.out.println(k + " : " + v);});
    }
}
