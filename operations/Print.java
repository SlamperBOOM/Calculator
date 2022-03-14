package operations;

import calculator.*;
import exceptions.CalculatorException;
import exceptions.EmptyStackException;
import java.util.List;

public class Print implements Operation {
    @Override
    public void calc(List<Value> arguments, Context context) throws CalculatorException {
        List<Double> stack = context.getStack();
        if(stack.size() == 0) {
            throw new EmptyStackException("Print: nothing to print");
        }
        else {
            System.out.println(stack.get(stack.size() - 1));
        }
    }
}
