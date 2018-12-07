package com.aop;

public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("CalculatorImpl...invoke...");
        return i / j;
    }
}
