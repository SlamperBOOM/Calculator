package operations;
import calculator.Calculator;
import calculator.Operation;
import java.util.*;

public class Push implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack, Calculator calculator) {
        Double arg;
        try{
            arg = Double.valueOf(arguments.get(0));
        }
        catch (NumberFormatException e){
            arg = calculator.getParameter(arguments.get(0));
        }
        stack.add(arg);
        return stack;
    }
}
