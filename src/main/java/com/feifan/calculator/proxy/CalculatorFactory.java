package com.feifan.calculator.proxy;

import com.feifan.calculator.domain.CalculatorRegister;
import com.feifan.calculator.domain.SimpleProcessUnit;
import com.feifan.calculator.facade.Calculator;
import com.feifan.calculator.facade.CalculatorFacade;

import java.lang.reflect.Proxy;

public class CalculatorFactory {

    public static CalculatorFacade createCalculatorWithCommandLineDisplay() {
        CalculatorFacade calculator = new Calculator(new SimpleProcessUnit(), new CalculatorRegister());
        //AOP Proxy for current number display
        CalculatorDisplayProxy calculatorDisplayProxy = new CalculatorDisplayProxy(calculator);
        return (CalculatorFacade) Proxy.newProxyInstance(calculatorDisplayProxy.getClass().getClassLoader(), calculator
                .getClass().getInterfaces(), calculatorDisplayProxy);

    }

    public static CalculatorFacade createSimpleCalculator() {
        return new Calculator(new SimpleProcessUnit(), new CalculatorRegister());
    }
}
