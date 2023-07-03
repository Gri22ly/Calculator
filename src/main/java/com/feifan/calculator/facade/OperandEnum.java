package com.feifan.calculator.facade;

/**
 * OperandEnum
 * <p>
 * 运算符枚举
 *
 * @author feifan
 */

public enum OperandEnum {
    /**
     * "+"
     */
    ADD('+'),
    /**
     * "-"
     */
    MINUS('-'),
    /**
     * "*"
     */
    MULTIPLY_BY('*'),
    /**
     * "/"
     */
    DIVIDED_BY('/'),

    /**
     * nothing
     */
    NONE(' ');

    private final char operand;

    OperandEnum(char operand) {
        this.operand = operand;
    }

    public char getOperand() {
        return operand;
    }
}
