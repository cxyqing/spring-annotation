package com.ex;

import com.aop.*;
import com.config.AppConfigForAop;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class AopTest {
    private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigForAop.class);

    @Test
    public void printBeans(){

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    public void test04(){
        MathCalculator mathCalculator = (MathCalculator) ctx.getBean("mathCalculator");
        int result = mathCalculator.div(10, 2);
        System.out.println(result);
    }
 @Test
    public void test03(){
        Calculator calculator = ctx.getBean(Calculator.class);
        int result = calculator.div(10, 0);
        System.out.println(result);
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
    @Test
    public void cglib(){
        BookFacade bookFacade = new BookFacade();
//        BookFacadeCglib bfc = new BookFacadeCglib();
//        BookFacade instance = (BookFacade) bfc.getInstance(bookFacade);
//        instance.addBook();
        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(BookFacade.class);
//        enhancer.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("before invoke target method....");
//                methodProxy.invokeSuper(o,objects);
//                System.out.println("after invoke target method....");
//                return null;
//            }
//        });
//        BookFacade o = (BookFacade)enhancer.create();
//        o.addBook();
        BookFacade proxy = (BookFacade) Enhancer.create(BookFacade.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before invoke target method....");
                Object result = method.invoke(bookFacade, objects);
                System.out.println("after invoke target method....");
                return result;
            }
        });
        int i = proxy.addBook(10, 2);
        System.out.println("result: " + i);
    }
}
