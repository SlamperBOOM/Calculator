package operations;

import calculator.*;
import exceptions.CalculatorException;
import exceptions.NoArgumentsException;

import java.util.List;

public class Define implements Operation{
    @Override
    public void calc(List<Value> arguments, Context context) throws CalculatorException {
        try{
            if(arguments.size() < 2){
                throw new NoArgumentsException("Define: too few arguments, " + arguments.size() + " given, 2 expected");
            }
            String parameterName = arguments.get(0).toString();
            Double parameter = arguments.get(1).toDouble();
            context.addParameter(parameterName, parameter);
        }
        catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
}
