package com.feifan.calculator.facade;//package com.feifan.calculator.facade;
//
//import com.feifan.CalculatorNumber;
//
///**
// *
// *
// * @author feifan
// */
//public class ExceptionState implements ICalculatorState {
//
//    private final Calculator calculator;
//
//    ExceptionState(Calculator calculator) {
//        this.calculator = calculator;
//    }
//
//
//    @Override
//    public void pressOperand(OperandEnum operandEnum) throws Exception {
//
//        //change state to wait for Number
//        calculator.setState(calculator.getWaitForEqualInputState());
//
//        //calculate
//        CalculatorNumber calculatorNumber = calculator.calculateCurrent();
//
//        //update number
//        calculator.setCurrentBufferNumber(calculatorNumber);
//        calculator.setCurrentRegisterNumber(calculatorNumber);
//
//        //update operand
//        calculator.setCurrentOperand(operandEnum);
//    }
//
//    @Override
//    public void pressEqual() throws Exception{
//
//        //change state to wait for Operand
//        calculator.setState(calculator.getWaitForOperandInputState());
//
//        //calculate
//        CalculatorNumber calculatorNumber = calculator.calculateCurrent();
//
//        //update both buffer number and register;
//        calculator.setCurrentBufferNumber(calculatorNumber);
//        calculator.setCurrentRegisterNumber(calculatorNumber);
//        //keep the operand
//    }
//
//    @Override
//    public void pressUndo() {
//    }
//
//    @Override
//    public void pressRedo() {
//
//    }
//
//}
