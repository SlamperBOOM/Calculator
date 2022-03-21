package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import calculator.Calculator;
import exceptions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class ExceptionsTest {
    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("EmptyStackException in Print")
    void testEmptyStackPrint(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("print");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(exceptions.EmptyStackException.class, e.getClass());
            assertEquals("Print: nothing to print", e.getMessage());
        }
    }

    @Test
    @DisplayName("EmptyStackException in Sqrt")
    void testEmptyStackSqrt(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("sqrt");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(exceptions.EmptyStackException.class, e.getClass());
            assertEquals("SquareRoot: no values in stack", e.getMessage());
        }
    }

    @Test
    @DisplayName("EmptyStackException in Pop")
    void testEmptyStackPop(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("pop");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(exceptions.EmptyStackException.class, e.getClass());
            assertEquals("Pop: no values in stack", e.getMessage());
        }
    }

    @Test
    @DisplayName("TooSmallStackException in Sum")
    void testTooSmallStackSum(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("sum");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(TooSmallStackException.class, e.getClass());
            assertEquals("Sum: too small stack. Must contains at least 2 values, actual size - 0", e.getMessage());
        }
    }

    @Test
    @DisplayName("TooSmallStackException in Subtract")
    void testTooSmallStackSubtract(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("subtract");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(TooSmallStackException.class, e.getClass());
            assertEquals("Subtract: too small stack. Must contains at least 2 values, actual size - 0", e.getMessage());
        }
    }

    @Test
    @DisplayName("TooSmallStackException in Multiply")
    void testTooSmallStackMultiply(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("multiply");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(TooSmallStackException.class, e.getClass());
            assertEquals("Multiply: too small stack. Must contains at least 2 values, actual size - 0", e.getMessage());
        }
    }

    @Test
    @DisplayName("TooSmallStackException in Divide")
    void testTooSmallStackDivide(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("divide");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(TooSmallStackException.class, e.getClass());
            assertEquals("Divide: too small stack. Must contains at least 2 values, actual size - 0", e.getMessage());
        }
    }

    @Test
    @DisplayName("ImpossibleCalculationException in Sqrt")
    void testImpossibleCalculationSqrt(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("-2");
        arguments.add("sqrt");
        try{
            calculator.calculate(arguments.subList(0, 2));
            calculator.calculate(arguments.subList(2, 3));
        }catch (CalculatorException e){
            assertEquals(ImpossibleCalculationException.class, e.getClass());
            assertEquals("SquareRoot: cannot calculate values below zero. Value - -2.0", e.getMessage());
        }
    }

    @Test
    @DisplayName("NoArgumentsException in Push")
    void testNoArgumentsExceptionPush(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("push");
        arguments.add("-2");
        arguments.add("sqrt");
        try{
            calculator.calculate(arguments.subList(0, 2));
            calculator.calculate(arguments.subList(2, 3));
        }catch (CalculatorException e){
            assertEquals(ImpossibleCalculationException.class, e.getClass());
            assertEquals("SquareRoot: cannot calculate values below zero. Value - -2.0", e.getMessage());
        }
    }

    @Test
    @DisplayName("NoArgumentsException in Define")
    void testNoArgumentsExceptionDefine(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("define");
        arguments.add("a");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(NoArgumentsException.class, e.getClass());
            assertEquals("Define: too few arguments, 1 given, 2 expected", e.getMessage());
        }
    }

    @Test
    @DisplayName("NoConvertAvailable in Define")
    void testNoConvertAvailableExceptionDefine(){
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
    }

    @Test
    @DisplayName("NoParameterException in Push")
    void testNoParameterExceptionDefine(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("define");
        arguments.add("a");
        arguments.add("4");
        arguments.add("push");
        arguments.add("b");
        try{
            calculator.calculate(arguments.subList(0, 3));
            calculator.calculate(arguments.subList(3, 5));
        }catch (CalculatorException e){
            assertEquals(NoParameterException.class, e.getClass());
            assertEquals("getParameter: no parameter by name b", e.getMessage());
        }
    }

    @Test
    @DisplayName("NoSuchOperationException")
    void testNoSuchOperationException(){
        List<String> arguments = new ArrayList<String>();
        arguments.add("squareRoot");
        try{
            calculator.calculate(arguments);
        }catch (CalculatorException e){
            assertEquals(NoSuchOperationException.class, e.getClass());
            assertEquals("getOperation: there is no operation called squareRoot", e.getMessage());
        }
    }
}
