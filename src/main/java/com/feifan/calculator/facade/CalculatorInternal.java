package com.feifan.calculator.facade;

import com.feifan.calculator.domain.CalculatorNumber;
import com.feifan.calculator.exception.CalculationException;

public interface CalculatorInternal {

    CalculatorNumber getCurrentBufferNumber();

    void clearBufferNumber();

    CalculatorNumber getCurrentRegisterNumber();

    void setCurrentRegisterNumber(CalculatorNumber number);

    void setCurrentOperand(OperandEnum currentOperand);

    CalculatorNumber calculateCurrent() throws CalculationException;

    void setState(ICalculatorState state);

    FirstNumberState getFirstNumberState();

    SecondNumberState getSecondNumberState();

    void undo();

    void redo();

}
