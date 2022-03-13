package operations;
import calculator.Calculator;
import calculator.Operation;
import exceptions.CalculatorException;
import exceptions.EmptyStackException;
import java.util.*;

public class Pop implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack, Calculator calculator) throws CalculatorException {
        if(stack.size() == 0) {
            throw new EmptyStackException("Pop: no values in stack");
        }
        else {
            stack.remove(stack.size() - 1);
        }
        return stack;
    }
}