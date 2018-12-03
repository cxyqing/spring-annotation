package com.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {

    private Calculator calculator;

    public MyInvocationHandler(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " invoke before with " + Arrays.toString(args));
        Object result = method.invoke(calculator, args);
        System.out.println(method.getName() + " invoke after with " + Arrays.toString(args));
        return result;
    }

    public Calculator proxy(){

        return (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),calculator.getClass().getInterfaces(),this);
    }
}
