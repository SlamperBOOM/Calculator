package Operations;

import Calculator.Calculator;
import Calculator.Operation;

import java.util.List;

public class Define implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack){
        try{
            String parametername = arguments.get(0);
            Double parameter = Double.valueOf(arguments.get(1));
            Calculator.addParameter(parametername, parameter);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
        return stack;
    }
}
