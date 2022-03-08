package Operations;
import Calculator.Operation;
import java.util.*;

public class Pop implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack) {
        stack.remove(stack.size() - 1);
        return stack;
    }
}