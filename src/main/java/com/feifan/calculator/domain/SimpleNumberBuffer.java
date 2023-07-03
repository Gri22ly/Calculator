package com.feifan.calculator.domain;

import java.math.BigDecimal;

/**
 * SimpleNumberBuffer
 * <p>
 * 数字缓冲区
 */
public class SimpleNumberBuffer implements NumberBuffer {

    private StringBuilder buffer;

    SimpleNumberBuffer() {
        this.buffer = new StringBuilder();
    }

    @Override
    public void append(char c) {
        buffer.append(c);
    }

    @Override
    public CalculatorNumber read() {
        if (buffer.length() == 0) {
            return null;
        }
        return new CalculatorNumber(new BigDecimal(buffer.toString()));
    }

    @Override
    public void clear() {
        this.buffer = new StringBuilder();
    }

}
