package com.feifan.calculator.domain;

import com.feifan.calculator.exception.CalculationException;

import java.math.BigDecimal;

/**
 * CalculatorNumber
 * <p>
 * Domain Model
 *
 * @author feifan
 */
public class CalculatorNumber {

    static final BigDecimal ZERO = new BigDecimal(0);

    static final int DEFAULT_SCALE = 10;

    private final BigDecimal num;

    public CalculatorNumber(BigDecimal num) {
        this.num = num;
    }

    CalculatorNumber add(CalculatorNumber calculatorNumber) {
        return new CalculatorNumber(this.num.add(calculatorNumber.num));
    }

    CalculatorNumber minus(CalculatorNumber calculatorNumber) {
        return new CalculatorNumber(this.num.subtract(calculatorNumber.num));
    }

    CalculatorNumber multiplyBy(CalculatorNumber calculatorNumber) {
        return new CalculatorNumber(this.num.multiply(calculatorNumber.num));
    }

    CalculatorNumber dividedBy(CalculatorNumber divisor) throws CalculationException {
        if (ZERO.compareTo(divisor.num) == 0) {
            throw new CalculationException("divided by zero");
        }
        return new CalculatorNumber(this.num.divide(divisor.num, DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP));
    }

    @Override
    public String toString() {
        return num.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CalculatorNumber) {
            return ((CalculatorNumber) obj).num.compareTo(this.num) == 0;
        }
        return false;
    }
}
