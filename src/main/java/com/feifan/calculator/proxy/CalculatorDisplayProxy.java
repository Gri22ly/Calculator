package com.feifan.calculator.proxy;

import com.feifan.calculator.facade.CalculatorFacade;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 */
public class CalculatorDisplayProxy implements InvocationHandler {

    private final CalculatorFacade calculator;

    public CalculatorDisplayProxy(CalculatorFacade calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(calculator, args);
        //print current result to the command line
        System.out.println(">> " + calculator.getCurrentNumber() + "");
        return proxy;
    }

}
