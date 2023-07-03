package com.feifan.calculator.facade;

import com.feifan.calculator.domain.CalculatorNumber;
import com.feifan.calculator.exception.CalculationException;

/**
 * CalculatorFacade
 * <p>
 * External functions provided to users
 *
 * @author feifan
 */
public interface CalculatorFacade {

    CalculatorNumber getCurrentNumber();

    void pressDigit(DigitEnum digit);

    void pressOperand(OperandEnum operand) throws CalculationException;

    void pressEqual() throws Exception;

    void pressUndo();

    void pressRedo();

    void pressStartOrClear();
}
