package com.feifan.calculator.domain;

import com.feifan.calculator.exception.CalculationException;

/**
 * CPU
 *
 * @author feifan
 */
public interface ProcessUnit {

    /**
     * apply add
     *
     * @param a number
     * @param b number
     * @return a + b
     */
    CalculatorNumber add(CalculatorNumber a, CalculatorNumber b);

    /**
     * apply minus
     *
     * @param a number
     * @param b number
     * @return a - b
     */
    CalculatorNumber minus(CalculatorNumber a, CalculatorNumber b);

    /**
     * apply multiply by
     *
     * @param a number
     * @param b number
     * @return a * b
     */
    CalculatorNumber multiplyBy(CalculatorNumber a, CalculatorNumber b);

    /**
     * apply add
     *
     * @param dividend dividend
     * @param divisor  divisor
     * @return dividend / divisor
     * @throws CalculationException
     */
    CalculatorNumber dividedBy(CalculatorNumber dividend, CalculatorNumber divisor) throws CalculationException;


}
