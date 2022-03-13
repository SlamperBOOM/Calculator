package operations;

import calculator.Calculator;
import calculator.Operation;
import exceptions.CalculatorException;
import exceptions.ImpossibleCalculationException;
import java.util.List;

public class Squareroot implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack, Calculator calculator) throws CalculatorException {
        Double arg = stack.get(stack.size() - 1);
        if(arg < 0){
            throw new ImpossibleCalculationException("Square root: cannot calculate values below zero. Value - "
                    + String.valueOf(arg));
        }
        else {
            stack.remove(stack.size() - 1);
            stack.add(Math.sqrt(arg));
        }
        return stack;
    }
}