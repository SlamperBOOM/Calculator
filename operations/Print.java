package operations;

import calculator.Calculator;
import calculator.Operation;
import exceptions.CalculatorException;
import exceptions.EmptyStackException;
import java.util.List;

public class Print implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack, Calculator calculator) throws CalculatorException {
        if(stack.size() == 0) {
            throw new EmptyStackException("Print: nothing to print");
        }
        else {
            System.out.println(stack.get(stack.size() - 1));
        }
        return stack;
    }
}
