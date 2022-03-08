package Operations;

import Calculator.Operation;
import java.util.List;

public class Squareroot implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack){
        Double arg = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        stack.add(Math.sqrt(arg));
        return stack;
    }
}