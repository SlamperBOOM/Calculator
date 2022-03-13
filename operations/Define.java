package operations;

import calculator.Calculator;
import calculator.Operation;

import java.util.List;

public class Define implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack, Calculator calculator){
        try{
            String parameterName = arguments.get(0);
            Double parameter = Double.valueOf(arguments.get(1));
            calculator.addParameter(parameterName, parameter);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        return stack;
    }
}
