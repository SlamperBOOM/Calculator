package Operations;
import Calculator.Calculator;
import Calculator.Operation;
import java.util.*;

public class Push implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack) {
        Double arg = 0.0;
        try{
            arg = Double.valueOf(arguments.get(0));
        }
        catch (NumberFormatException e){
            arg = Calculator.getParameter(arguments.get(0));
        }
        stack.add(arg);
        return stack;
    }
}
