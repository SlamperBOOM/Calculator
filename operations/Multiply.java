package operations;

import calculator.*;
import exceptions.*;
import java.util.List;

public class Multiply implements Operation {
    @Override
    public void calc(List<Value> arguments, Context context) throws CalculatorException {
        List<Double> stack = context.getStack();
        if(stack.size() < 2) {
            throw new TooSmallStackException("Multiply: too small stack. Must contains at least 2 values, actual size - ",
                    stack.size());
        }
        else {
            Double arg1 = stack.get(stack.size() - 1);
            Double arg2 = stack.get(stack.size() - 2);
            stack.remove(stack.size() - 1);
            stack.remove(stack.size() - 1);
            stack.add(arg1 * arg2);
        }
    }
}
