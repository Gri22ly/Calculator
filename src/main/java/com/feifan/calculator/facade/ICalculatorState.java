package com.feifan.calculator.facade;

import com.feifan.calculator.exception.CalculationException;

/**
 * ICalculatorState
 * <p>
 * The possible actions of calculator
 * that can change the current state
 */
public interface ICalculatorState {

    void pressOperand(OperandEnum operandEnum) throws CalculationException;

    void pressEqual() throws Exception;

    void pressUndo();

    void pressRedo();
}
