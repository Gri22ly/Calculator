package com.feifan.calculator.tool;

import com.feifan.calculator.exception.CalculationException;
import com.feifan.calculator.facade.CalculatorFacade;
import com.feifan.calculator.facade.DigitEnum;
import com.feifan.calculator.facade.OperandEnum;
import com.feifan.calculator.proxy.CalculatorFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * A Java Swing GUI for testing the calculator
 *
 * @author feifan
 */
public class SwingCalculator extends JFrame implements ActionListener {
    private String[] name = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", ".", "=", "/"};
    private JButton[] button = new JButton[name.length];
    private CalculatorFacade calculator = CalculatorFactory.createSimpleCalculator();

    private JTextField textField;

    private SwingCalculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel upper = new JPanel();
        JPanel lower = new JPanel();

        Container cp = getContentPane();
        cp.add(upper, BorderLayout.NORTH);
        cp.add(lower, BorderLayout.SOUTH);
        setSize(400, 200);

        upper.add(new JLabel("screen"));

        textField = new JTextField(11);
        textField.setEditable(false);
        textField.setBackground(new Color(200, 200, 80));
        textField.setText(calculator.getCurrentNumber() + "");
        upper.add(textField);

        JButton undoBtn = new JButton("undo");
        JButton redoBtn = new JButton("redo");
        upper.add(undoBtn);
        upper.add(redoBtn);

        GridLayout but = new GridLayout(4, 4, 2, 6);
        lower.setLayout(but);
        for (int i = 0; i < name.length; i++) {
            button[i] = new JButton(name[i]);
            lower.add(button[i]);
            button[i].addActionListener(this);
        }
        undoBtn.addActionListener((e) -> {
            calculator.pressUndo();
            textField.setText(calculator.getCurrentNumber() + "");
        });
        redoBtn.addActionListener((e) -> {
            calculator.pressRedo();
            textField.setText(calculator.getCurrentNumber() + "");
        });
    }

    public static void main(String[] args) {
        SwingCalculator c = new SwingCalculator();
        c.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[3]) {
            try {
                calculator.pressOperand(OperandEnum.ADD);
            } catch (CalculationException ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(), "Exception", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == button[7]) {
            try {
                calculator.pressOperand(OperandEnum.MINUS);
            } catch (Exception ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(), "Exception", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == button[11]) {
            try {
                calculator.pressOperand(OperandEnum.MULTIPLY_BY);
            } catch (Exception ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(), "Exception", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == button[15]) {
            try {
                calculator.pressOperand(OperandEnum.DIVIDED_BY);
            } catch (Exception ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(), "Exception", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == button[14]) {
            try {
                calculator.pressEqual();
            } catch (Exception ex) {
                JOptionPane.showConfirmDialog(null, ex.getMessage(), "Exception", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            DigitEnum digitEnum = Arrays.stream(DigitEnum.values()).filter(em -> String.valueOf(em.getDigit()).equals(e.getActionCommand())).findFirst().get();
            calculator.pressDigit(digitEnum);
        }
        textField.setText(calculator.getCurrentNumber() + "");
    }
}

