package com.ex;

import com.aop.Calculator;
import com.aop.CalculatorImpl;
import com.aop.MyInvocationHandler;
import com.config.AppConfigForAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AopTest {
    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigForAop.class);
    @Test
    public void test03(){
        Calculator calculator = ctx.getBean(Calculator.class);
        System.out.println(calculator.div(10, 0));
    }

    @Test
    public void test02(){
        MyInvocationHandler mi  = new MyInvocationHandler(new CalculatorImpl());
        Calculator proxy = mi.proxy();
        System.out.println(proxy.div(10, 0));
    }
    @Test
    public void test01(){
        Calculator c = new CalculatorImpl();
        Calculator proxy = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), new Class[]{Calculator.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName() + " invoke before with " + Arrays.toString(args));
                Object result = method.invoke(c, args);
                System.out.println(method.getName() + " invoke after with " + Arrays.toString(args));

                return result;
            }
        });
        System.out.println(proxy.div(10, 2));
    }
}
