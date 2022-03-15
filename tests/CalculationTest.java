package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import calculator.Calculator;
import exceptions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class CalculationTest {
    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test Push")
    void testPush(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("4");
        try {
            calculator.calculate(arguments);
        }catch (CalculatorException e) {
            System.err.println(e.getMessage());
        }
        List<Double> stack = calculator.getConstantStack();
        assertEquals("4.0", String.valueOf(stack.get(stack.size() - 1)));

        arguments.remove("4");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(NoArgumentsException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Test Sum")
    void testSum(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("4");
        arguments.add("sum");
        try {
            calculator.calculate(arguments.subList(0, 2));

            calculator.calculate(arguments.subList(2, 3));
        } catch (CalculatorException e){
            assertEquals(TooSmallStackException.class, e.getClass());
            assertEquals("Sum: too small stack. Must contains at least 2 values, actual size - 1", e.getMessage());
        } finally {
            arguments.add("push");
            arguments.add("5");
            try{
                calculator.calculate(arguments.subList(3, 5));

                calculator.calculate(arguments.subList(2, 3));
            }catch (CalculatorException e) {
                System.err.println(e.getMessage());
            }
            List<Double> stack = calculator.getConstantStack();
            assertEquals("9.0", String.valueOf(stack.get(stack.size() - 1)));
        }
    }

    @Test
    @DisplayName("Test Multiply")
    void testMultiply(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("4");
        arguments.add("multiply");
        try {
            calculator.calculate(arguments.subList(0, 2));

            calculator.calculate(arguments.subList(2, 3));
        } catch (CalculatorException e){
            assertEquals(TooSmallStackException.class, e.getClass());
            assertEquals("Multiply: too small stack. Must contains at least 2 values, actual size - 1", e.getMessage());
        } finally {
            arguments.add("push");
            arguments.add("5");
            try{
                calculator.calculate(arguments.subList(3, 5));

                calculator.calculate(arguments.subList(2, 3));
            }catch (CalculatorException e) {
                System.err.println(e.getMessage());
            }
            List<Double> stack = calculator.getConstantStack();
            assertEquals("20.0", String.valueOf(stack.get(stack.size() - 1)));
        }
    }

    @Test
    @DisplayName("Test Subtract")
    void testSubtract(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("4");
        arguments.add("subtract");
        try {
            calculator.calculate(arguments.subList(0, 2));

            calculator.calculate(arguments.subList(2, 3));
        } catch (CalculatorException e){
            assertEquals(TooSmallStackException.class, e.getClass());
            assertEquals("Subtract: too small stack. Must contains at least 2 values, actual size - 1", e.getMessage());
        } finally {
            arguments.add("push");
            arguments.add("5");
            try{
                calculator.calculate(arguments.subList(3, 5));

                calculator.calculate(arguments.subList(2, 3));
            }catch (CalculatorException e) {
                System.err.println(e.getMessage());
            }
            List<Double> stack = calculator.getConstantStack();
            assertEquals("-1.0", String.valueOf(stack.get(stack.size() - 1)));
        }
    }

    @Test
    @DisplayName("Test Divide")
    void testDivide(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("4");
        arguments.add("divide");
        try {
            calculator.calculate(arguments.subList(0, 2));

            calculator.calculate(arguments.subList(2, 3));
        } catch (CalculatorException e){
            assertEquals(TooSmallStackException.class, e.getClass());
            assertEquals("Divide: too small stack. Must contains at least 2 values, actual size - 1", e.getMessage());
        } finally {
            arguments.add("push");
            arguments.add("5");
            try{
                calculator.calculate(arguments.subList(3, 5));

                calculator.calculate(arguments.subList(2, 3));
            }catch (CalculatorException e) {
                System.err.println(e.getMessage());
            }
            List<Double> stack = calculator.getConstantStack();
            assertEquals("0.8", String.valueOf(stack.get(stack.size() - 1)));
        }
    }

    @Test
    @DisplayName("Test SquareRoot")
    void testSquareRoot(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("-4");
        arguments.add("sqrt");
        try {
            calculator.calculate(arguments.subList(0, 2));

            calculator.calculate(arguments.subList(2, 3));
        } catch (CalculatorException e){
            assertEquals(ImpossibleCalculationException.class, e.getClass());
            assertEquals("Square root: cannot calculate values below zero. Value - -4.0", e.getMessage());
        } finally {
            arguments.add("push");
            arguments.add("4");
            try{
                calculator.calculate(arguments.subList(3, 5));

                calculator.calculate(arguments.subList(2, 3));
            }catch (CalculatorException e) {
                System.err.println(e.getMessage());
            }
            List<Double> stack = calculator.getConstantStack();
            assertEquals("2.0", String.valueOf(stack.get(stack.size() - 1)));
        }
    }

    @Test
    @DisplayName("Test Parameters")
    void testParameters(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("define");
        arguments.add("a");
        arguments.add("a");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(NoConvertAvailableException.class, e.getClass());
            assertEquals("Value.toDouble: couldn't convert a to Double", e.getMessage());
        }
        finally {
            arguments.remove("a");
            arguments.add("4");
            arguments.add("push");
            arguments.add("a");
            try {
                calculator.calculate(arguments.subList(3, 5));
            } catch (CalculatorException e) {
                assertEquals(NoParameterException.class, e.getClass());
                assertEquals("getParameter: no parameter by name a", e.getMessage());
            }
            try{
                calculator.calculate(arguments.subList(0, 3));
                calculator.calculate(arguments.subList(3, 5));
            }catch (CalculatorException e){
                System.err.println(e.getMessage());
            }finally {
                List<Double> stack = calculator.getConstantStack();
                assertEquals(String.valueOf(stack.get(stack.size() - 1)), "4.0");
            }
        }
    }
}
