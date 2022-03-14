package operations;

import calculator.*;
import exceptions.CalculatorException;
import exceptions.NoArgumentsException;

import java.util.List;

public class Push implements Operation {
    @Override
    public void calc(List<Value> arguments, Context context) throws CalculatorException {
        if(arguments.size() < 1){
            throw new NoArgumentsException("Push: no arguments given to the method");
        }
        Double arg;
        if(arguments.get(0).isIdentifier()) {
            arg = arguments.get(0).toDouble();
        }
        else{
            arg = context.getParameter(arguments.get(0).toString());
        }
        context.getStack().add(arg);
    }
}
