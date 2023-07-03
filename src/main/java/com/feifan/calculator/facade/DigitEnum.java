package com.feifan.calculator.facade;

public enum DigitEnum {

    ZERO('0'),

    ONE('1'),

    TWO('2'),

    THREE('3'),

    FOUR('4'),

    FIVE('5'),

    SIX('6'),

    SEVEN('7'),

    EIGHT('8'),

    NINE('9'),

    DOT('.');


    private final char digit;

    DigitEnum(char digit) {
        this.digit = digit;
    }

    public char getDigit() {
        return digit;
    }
}
