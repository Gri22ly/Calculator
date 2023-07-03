package com.feifan.calculator.tool;

import com.feifan.calculator.facade.CalculatorFacade;
import com.feifan.calculator.facade.DigitEnum;
import com.feifan.calculator.facade.OperandEnum;
import com.feifan.calculator.proxy.CalculatorFactory;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Program entry point
 *
 * @author feifan
 * @date 6/29/2023
 */
public class CommandLineLauncher {
    public static void main(String[] args) throws Exception {
        CalculatorFacade calculator = CalculatorFactory.createCalculatorWithCommandLineDisplay();
        calculator.pressStartOrClear();
        Scanner scanner = new Scanner(System.in);
        boolean isOn = true;
        while (isOn) {
            System.out.print(">> ");

            String s = scanner.nextLine().trim();
            if (s.length() != 1) {
                System.out.println("Please input digit or operand");
                continue;
            }
            char c = s.charAt(0);
            boolean isDigit = Arrays.stream(DigitEnum.values()).anyMatch(e -> e.getDigit() == c);
            boolean isOperand = Arrays.stream(OperandEnum.values()).anyMatch(e -> e.getOperand() == c);
            if (isDigit) {
                DigitEnum digitEnum = Arrays.stream(DigitEnum.values()).filter(e -> e.getDigit() == c).findFirst().get();
                calculator.pressDigit(digitEnum);
            } else if (isOperand) {
                OperandEnum operandEnum = Arrays.stream(OperandEnum.values()).filter(e -> e.getOperand() == c).findFirst().get();
                calculator.pressOperand(operandEnum);
            } else if (c == '=') {
                calculator.pressEqual();
            } else {
                isOn = false;
            }
        }
    }
}
