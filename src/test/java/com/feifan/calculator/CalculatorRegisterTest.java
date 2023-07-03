package com.feifan.calculator;

import com.feifan.calculator.domain.CalculatorNumber;
import com.feifan.calculator.domain.ProcessUnit;
import com.feifan.calculator.domain.SimpleProcessUnit;
import com.feifan.calculator.exception.CalculationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CalculatorRegisterTest {

    private ProcessUnit cpu;

    @BeforeEach
    void initCalculator() {
        cpu = new SimpleProcessUnit();
    }

    @Test
    void addIntegerTest() {
        String oneStr = "999999999999999999999999999999999999999999999999999";
        String twoStr = "1";
        String resStr = "1000000000000000000000000000000000000000000000000000";

        CalculatorNumber one = new CalculatorNumber(new BigDecimal(oneStr));
        CalculatorNumber two = new CalculatorNumber(new BigDecimal(twoStr));
        CalculatorNumber res = new CalculatorNumber(new BigDecimal(resStr));

        Assertions.assertEquals(res, cpu.add(one, two));
    }

    @Test
    void dividedByZeroTest() {
        CalculatorNumber zero = new CalculatorNumber(new BigDecimal(0));
        Assertions.assertThrows(CalculationException.class, () -> {
            cpu.dividedBy(zero, zero);
        });
    }


}
