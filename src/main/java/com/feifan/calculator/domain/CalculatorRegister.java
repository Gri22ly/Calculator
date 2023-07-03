package com.feifan.calculator.domain;

import com.feifan.calculator.facade.DigitEnum;
import com.feifan.calculator.facade.OperandEnum;

import java.util.LinkedList;

/**
 * CalculatorRegister
 * <p>
 * 寄存器
 *
 * @author feifan
 */
public class CalculatorRegister {

    private static final CalculatorNumber INIT_CALCULATOR_NUMBER = new CalculatorNumber(CalculatorNumber.ZERO);

    private static final int UNDO_MAX_DEPTH = 20;

    private static final int UNDO_MAX_DEFAULT = 10;

    private static final int UNDO_MIN_DEPTH = 1;

    /**
     * 缓冲区
     */
    private final NumberBuffer numberBuffer;
    /**
     * 前进栈
     */
    private final LinkedList<CalculatorNumber> redoStack;
    /**
     * 回退栈
     */
    private final LinkedList<CalculatorNumber> undoStack;
    /**
     * 回退/前进 最大深度
     */
    private final int undoDepth;
    /**
     * 当前寄存数
     */
    private CalculatorNumber currentRegisterNumber;
    /**
     * 当前寄存操作
     */
    private OperandEnum currentOperand;


    private CalculatorRegister(int undoDepth) {
        if (undoDepth < UNDO_MIN_DEPTH || undoDepth > UNDO_MAX_DEPTH) {
            throw new IllegalArgumentException("Max undo/redo step depth should be larger than " + UNDO_MIN_DEPTH + " or less than " + UNDO_MAX_DEPTH);
        }
        this.numberBuffer = new SimpleNumberBuffer();
        this.undoDepth = undoDepth;
        this.redoStack = new LinkedList<>();
        this.undoStack = new LinkedList<>();
        reset();
    }

    public CalculatorRegister() {
        this(UNDO_MAX_DEFAULT);
    }

    public void reset() {
        this.redoStack.clear();
        this.undoStack.clear();
        this.numberBuffer.clear();
        this.currentOperand = OperandEnum.NONE;
        this.currentRegisterNumber = INIT_CALCULATOR_NUMBER;
    }

    public CalculatorNumber getCurrentRegisterNumber() {
        return this.currentRegisterNumber;
    }

    public void setCurrentRegisterNumber(CalculatorNumber calculatorNumber) {
        this.undoStack.push(currentRegisterNumber);
        this.currentRegisterNumber = calculatorNumber;
        depthCheck();
    }

    public CalculatorNumber readNumberFromBuffer() {
        CalculatorNumber bufferedNumber = this.numberBuffer.read();
        return bufferedNumber == null ? getCurrentRegisterNumber() : bufferedNumber;
    }

    public void clearBuffer() {
        this.numberBuffer.clear();
    }

    public void appendDigitToBuffer(DigitEnum digitEnum) {
        this.numberBuffer.append(digitEnum.getDigit());
    }

    public void undo() {
        if (this.undoStack.isEmpty()) {
            return;
        }
        this.redoStack.push(currentRegisterNumber);
        this.currentRegisterNumber = undoStack.pollFirst();
    }

    public void redo() {
        if (this.redoStack.isEmpty()) {
            return;
        }
        this.undoStack.push(currentRegisterNumber);
        this.currentRegisterNumber = redoStack.pollFirst();
    }


    private void depthCheck() {
        while (undoStack.size() > undoDepth) {
            undoStack.pollLast();
        }
    }

    public OperandEnum getCurrentOperand() {
        return currentOperand;
    }

    public void setCurrentOperand(OperandEnum currentOperand) {
        this.currentOperand = currentOperand;
    }
}
