package Operations;

import Calculator.Operation;
import Exceptions.ImpossibleCalculationException;
import java.util.List;

public class Squareroot implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack) throws ImpossibleCalculationException {
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