package calculator;

import exceptions.CalculatorException;

import java.util.*;

public class Calculator {
    private Context context;
    private OperationsCreator operations;

    public Calculator(){
        context = new Context();
        operations = new OperationsCreator();
    }

    public void calculate(List<String> arguments) throws CalculatorException { //0 - calculated successfully, 1 - EOF
        Operation operation = operations.getOperation(arguments.get(0));
        if(arguments.size() > 1) {
            operation.calc(Value.convertStringList(arguments.subList(1, arguments.size())), context);
        }
        else{
            operation.calc(new ArrayList<Value>(), context);
        }
    }
}
