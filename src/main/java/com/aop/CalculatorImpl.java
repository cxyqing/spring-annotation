package com.aop;

public class CalculatorImpl implements Calculator {
    @Override
    public int div(int i, int j) {
        System.out.println("CalculatorImpl...invoke...");
        return i / j;
    }
}
