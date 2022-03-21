package operations;

import calculator.*;
import exceptions.CalculatorException;
import exceptions.EmptyStackException;
import exceptions.ImpossibleCalculationException;
import java.util.List;

public class SquareRoot implements Operation {
    @Override
    public void calc(List<Value> arguments, Context context) throws CalculatorException {
        List<Double> stack = context.getStack();
        if(stack.size() < 1){
            throw new EmptyStackException("SquareRoot: no values in stack");
        }
        Double arg = stack.get(stack.size() - 1);
        if(arg < 0){
            throw new ImpossibleCalculationException("SquareRoot: cannot calculate values below zero. Value - "
                    + String.valueOf(arg));
        }
        else {
            stack.remove(stack.size() - 1);
            stack.add(Math.sqrt(arg));
        }
    }
}