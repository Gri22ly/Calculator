package com.feifan.calculator.facade;

import com.feifan.calculator.exception.CalculationException;

/**
 * FirstNumberState
 *
 * @author feifan
 */
public class FirstNumberState implements ICalculatorState {

    private final CalculatorInternal calculator;

    FirstNumberState(CalculatorInternal calculator) {
        this.calculator = calculator;
    }

    @Override
    public void pressOperand(OperandEnum operandEnum) {
        calculator.setState(calculator.getSecondNumberState());
        calculator.setCurrentRegisterNumber(calculator.getCurrentBufferNumber());
        calculator.clearBufferNumber();
        calculator.setCurrentOperand(operandEnum);
    }


    @Override
    public void pressEqual() throws CalculationException {
        calculator.setCurrentRegisterNumber(calculator.getCurrentBufferNumber());
        calculator.clearBufferNumber();
        calculator.setCurrentOperand(OperandEnum.NONE);
    }

    @Override
    public void pressUndo() {
        calculator.undo();
        calculator.clearBufferNumber();
        calculator.setCurrentOperand(OperandEnum.NONE);
    }

    @Override
    public void pressRedo() {
        calculator.redo();
        calculator.clearBufferNumber();
        calculator.setCurrentOperand(OperandEnum.NONE);
    }
}
