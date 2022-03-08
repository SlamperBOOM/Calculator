package Operations;

import Calculator.Operation;
import java.util.List;

public class Subtract implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack){
        Double arg1 = stack.get(stack.size() - 1);
        Double arg2 = stack.get(stack.size() - 2);
        stack.remove(stack.size() - 1);
        stack.remove(stack.size() - 1);
        stack.add(arg2 - arg1);
        return stack;
    }
}