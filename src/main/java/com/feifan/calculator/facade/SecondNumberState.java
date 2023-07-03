package com.feifan.calculator.facade;

import com.feifan.calculator.domain.CalculatorNumber;
import com.feifan.calculator.exception.CalculationException;

/**
 * SecondNumberState
 *
 * @author feifan
 */
public class SecondNumberState implements ICalculatorState {

    private final CalculatorInternal calculator;

    SecondNumberState(CalculatorInternal calculator) {
        this.calculator = calculator;
    }

    @Override
    public void pressOperand(OperandEnum operandEnum) throws CalculationException {
        CalculatorNumber calculatorNumber = calculator.calculateCurrent();
        calculator.setCurrentRegisterNumber(calculatorNumber);
        calculator.clearBufferNumber();
        calculator.setCurrentOperand(operandEnum);
    }

    @Override
    public void pressEqual() throws CalculationException {
        calculator.setState(calculator.getFirstNumberState());
        calculator.setCurrentRegisterNumber(calculator.calculateCurrent());
        calculator.clearBufferNumber();
        calculator.setCurrentOperand(OperandEnum.NONE);
    }

    @Override
    public void pressUndo() {
        calculator.setState(calculator.getFirstNumberState());
        calculator.undo();
        calculator.clearBufferNumber();
        calculator.setCurrentOperand(OperandEnum.NONE);
    }

    @Override
    public void pressRedo() {
        calculator.setState(calculator.getFirstNumberState());
        calculator.redo();
        calculator.clearBufferNumber();
        calculator.setCurrentOperand(OperandEnum.NONE);
    }
}
