package com.feifan.calculator.domain;

import com.feifan.calculator.exception.CalculationException;

/**
 * SimpleProcessUnit
 *
 * @author feifan
 */
public class SimpleProcessUnit implements ProcessUnit {

    @Override
    public CalculatorNumber add(CalculatorNumber a, CalculatorNumber b) {
        return a.add(b);
    }

    @Override
    public CalculatorNumber minus(CalculatorNumber a, CalculatorNumber b) {
        return a.minus(b);
    }

    @Override
    public CalculatorNumber multiplyBy(CalculatorNumber a, CalculatorNumber b) {
        return a.multiplyBy(b);
    }

    @Override
    public CalculatorNumber dividedBy(CalculatorNumber dividend, CalculatorNumber divisor) throws CalculationException {
        return dividend.dividedBy(divisor);
    }
}
