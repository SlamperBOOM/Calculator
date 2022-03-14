package operations;

import calculator.*;
import exceptions.CalculatorException;
import exceptions.EmptyStackException;
import java.util.*;

public class Pop implements Operation {
    @Override
    public void calc(List<Value> arguments, Context context) throws CalculatorException {
        List<Double> stack = context.getStack();
        if(stack.size() == 0) {
            throw new EmptyStackException("Pop: no values in stack");
        }
        else {
            stack.remove(stack.size() - 1);
        }
    }
}