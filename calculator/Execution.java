package calculator;

import exceptions.CalculatorException;
import java.io.*;
import java.util.*;

public class Execution {
    public static void exec(Reader input){
        Calculator calculator = new Calculator();
        calculator.instance();
        List<Double> stack = new ArrayList<Double>();
        LineProcessing lines = new LineProcessing();
        while(true) {
            String[] splitLine = lines.readLine(input);
            if(splitLine[0].equals("")){
                break;
            }
            Operation operation = calculator.getOperation(splitLine[0]);
            try {
                operation.calc(Arrays.asList(splitLine).subList(1, splitLine.length), stack, calculator);
            } catch (CalculatorException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
