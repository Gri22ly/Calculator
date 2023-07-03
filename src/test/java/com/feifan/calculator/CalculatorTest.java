package com.feifan.calculator;

import com.feifan.calculator.domain.CalculatorRegister;
import com.feifan.calculator.domain.ProcessUnit;
import com.feifan.calculator.domain.SimpleProcessUnit;
import com.feifan.calculator.facade.Calculator;
import com.feifan.calculator.facade.CalculatorFacade;
import org.junit.jupiter.api.BeforeEach;

/**
 * CalculatorTest
 * <p>
 * TODO
 *
 * @author feifan
 */
public class CalculatorTest {

    CalculatorFacade calculator;

    @BeforeEach
    public void initCalculator() {
        ProcessUnit cpu = new SimpleProcessUnit();
        CalculatorRegister register = new CalculatorRegister();
        calculator = new Calculator(cpu, register);
    }


}
