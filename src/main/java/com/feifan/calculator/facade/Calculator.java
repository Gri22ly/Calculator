package com.feifan.calculator.facade;

import com.feifan.calculator.domain.CalculatorNumber;
import com.feifan.calculator.domain.CalculatorRegister;
import com.feifan.calculator.domain.ProcessUnit;
import com.feifan.calculator.exception.CalculationException;

/**
 * Calculator
 *
 * @author feifan
 */
public class Calculator implements CalculatorFacade, CalculatorInternal {

    /**
     * cpu
     */
    private final ProcessUnit processUnit;

    /**
     * register
     */
    private final CalculatorRegister calculatorRegister;
    private ICalculatorState state;


    // used by external users
    private FirstNumberState firstNumberState;
    private SecondNumberState secondNumberState;

    public Calculator(ProcessUnit processUnit, CalculatorRegister calculatorRegister) {
        this.processUnit = processUnit;
        this.calculatorRegister = calculatorRegister;
        initStates();
    }

    @Override
    public CalculatorNumber getCurrentNumber() {
        return calculatorRegister.readNumberFromBuffer();
    }

    @Override
    public void pressStartOrClear() {
        calculatorRegister.reset();
    }

    @Override
    public void pressDigit(DigitEnum digitEnum) {
        calculatorRegister.appendDigitToBuffer(digitEnum);
    }

    @Override
    public void pressOperand(OperandEnum operand) throws CalculationException {
        state.pressOperand(operand);
    }


    // internal business logic

    @Override
    public void pressEqual() throws Exception {
        state.pressEqual();
    }

    @Override
    public void pressUndo() {
        state.pressUndo();
    }

    @Override
    public void pressRedo() {
        state.pressRedo();
    }

    @Override
    public CalculatorNumber getCurrentBufferNumber() {
        return this.calculatorRegister.readNumberFromBuffer();
    }

    @Override
    public void clearBufferNumber() {
        this.calculatorRegister.clearBuffer();
    }

    @Override
    public CalculatorNumber getCurrentRegisterNumber() {
        return this.calculatorRegister.getCurrentRegisterNumber();
    }

    @Override
    public void setCurrentRegisterNumber(CalculatorNumber number) {
        this.calculatorRegister.setCurrentRegisterNumber(number);
    }

    @Override
    public void setCurrentOperand(OperandEnum currentOperand) {
        this.calculatorRegister.setCurrentOperand(currentOperand);
    }

    //state

    @Override
    public void undo() {
        this.calculatorRegister.undo();
    }

    @Override
    public void redo() {
        this.calculatorRegister.redo();
    }

    @Override
    public CalculatorNumber calculateCurrent() throws CalculationException {
        switch (calculatorRegister.getCurrentOperand()) {
            case ADD:
                return processUnit.add(getCurrentRegisterNumber(), getCurrentBufferNumber());
            case MINUS:
                return processUnit.minus(getCurrentRegisterNumber(), getCurrentBufferNumber());
            case MULTIPLY_BY:
                return processUnit.multiplyBy(getCurrentRegisterNumber(), getCurrentBufferNumber());
            case DIVIDED_BY:
                return processUnit.dividedBy(getCurrentRegisterNumber(), getCurrentBufferNumber());
            case NONE:
                return getCurrentBufferNumber();
            default:
                throw new UnsupportedOperationException();
        }
    }

    private void initStates() {
        firstNumberState = new FirstNumberState(this);
        secondNumberState = new SecondNumberState(this);
        this.state = firstNumberState;
    }


    @Override
    public void setState(ICalculatorState state) {
        this.state = state;
    }

    @Override
    public FirstNumberState getFirstNumberState() {
        return firstNumberState;
    }

    @Override
    public SecondNumberState getSecondNumberState() {
        return secondNumberState;
    }


}
