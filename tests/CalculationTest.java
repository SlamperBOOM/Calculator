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
        }finally {
            List<Double> stack = calculator.getConstantStack();
            assertEquals("4.0", String.valueOf(stack.get(stack.size() - 1)));
        }
    }

    @Test
    @DisplayName("Test Pop")
    void testPop(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("4");
        arguments.add("pop");
        int oldSize = 0;
        int newSize = 0;
        try {
            calculator.calculate(arguments.subList(0, 2));
            List<Double> stack = calculator.getConstantStack();
            oldSize = stack.size();
            calculator.calculate(arguments.subList(2, 3));
            stack = calculator.getConstantStack();
            newSize = stack.size();
        }catch (CalculatorException e) {
            System.err.println(e.getMessage());
        } finally {
            assertEquals(1, oldSize - newSize);
        }
    }

    @Test
    @DisplayName("Test Sum")
    void testSum(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("4");
        arguments.add("push");
        arguments.add("5");
        arguments.add("sum");
        try{
            calculator.calculate(arguments.subList(0, 2));
            calculator.calculate(arguments.subList(2, 4));
            calculator.calculate(arguments.subList(4, 5));
        }catch (CalculatorException e) {
            System.err.println(e.getMessage());
        } finally {
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
        arguments.add("push");
        arguments.add("5");
        arguments.add("multiply");
        try{
            calculator.calculate(arguments.subList(0, 2));
            calculator.calculate(arguments.subList(2, 4));
            calculator.calculate(arguments.subList(4, 5));
        }catch (CalculatorException e) {
            System.err.println(e.getMessage());
        } finally {
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
        arguments.add("push");
        arguments.add("5");
        arguments.add("subtract");
        try{
            calculator.calculate(arguments.subList(0, 2));
            calculator.calculate(arguments.subList(2, 4));
            calculator.calculate(arguments.subList(4, 5));
        }catch (CalculatorException e) {
            System.err.println(e.getMessage());
        }finally {
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
        arguments.add("push");
        arguments.add("5");
        arguments.add("divide");
        try{
            calculator.calculate(arguments.subList(0, 2));
            calculator.calculate(arguments.subList(2, 4));
            calculator.calculate(arguments.subList(4, 5));
        }catch (CalculatorException e) {
            System.err.println(e.getMessage());
        }finally {
            List<Double> stack = calculator.getConstantStack();
            assertEquals("0.8", String.valueOf(stack.get(stack.size() - 1)));
        }
    }

    @Test
    @DisplayName("Test SquareRoot")
    void testSquareRoot(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("4");
        arguments.add("sqrt");
        try{
            calculator.calculate(arguments.subList(0, 2));
            calculator.calculate(arguments.subList(2, 3));
        }catch (CalculatorException e) {
            System.err.println(e.getMessage());
        }finally {
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
        arguments.add("4");
        arguments.add("push");
        arguments.add("a");
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
