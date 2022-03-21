package calculator;

import exceptions.CalculatorException;

import java.util.*;

public class Calculator {
    private Context context;
    private OperationsCreator operations;

    public Calculator(){
        context = new Context();
        context.getLogger().logInitialization("Initialized (Context)");
        operations = new OperationsCreator();
        context.getLogger().logInitialization("Initialized (OperationsCreator)");
        context.getLogger().logInitialization("Initialized (Calculator)");
    }

    public List<Double> getConstantStack(){
        return List.copyOf(context.getStack()); //if we try to add/delete element from this stack, actual stack wouldn't be changed
    }

    public void calculate(List<String> arguments) throws CalculatorException{ //0 - calculated successfully, 1 - EOF
        Operation operation = operations.getOperation(arguments.get(0));
        try {
            List<Double> oldStack = getConstantStack();
            if (arguments.size() > 1) {
                operation.calc(Value.convertStringList(arguments.subList(1, arguments.size())), context);
            } else {
                operation.calc(new ArrayList<Value>(), context);
            }
            context.getLogger().logOperation(arguments, oldStack, getConstantStack());
        }catch (CalculatorException e){
            context.getLogger().logError(e);
            throw e;
        }
    }
}
