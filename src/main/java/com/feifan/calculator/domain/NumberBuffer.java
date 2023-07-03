package com.feifan.calculator.domain;

/**
 * Number buffer
 *
 * @author feifan
 */
public interface NumberBuffer {

    /**
     * append digit to buffer
     *
     * @param c digit
     */
    void append(char c);

    /**
     * read number from buffer
     *
     * @return number
     */
    CalculatorNumber read();

    /**
     * clear buffer
     */
    void clear();

}
