package calculator;

import exceptions.NoParameterException;

import java.util.*;

public class Context {
    private List<Double> stack = new ArrayList<Double>();
    private Map<String, Double> parameters = new HashMap<String, Double>();
    private CalculatorLogger logger = new CalculatorLogger();

    public List<Double> getStack(){
        return stack;
    }

    public CalculatorLogger getLogger(){
        return logger;
    }

    public void addParameter(String name, Double value){
        parameters.put(name, value);
    }

    public Double getParameter(String name) throws NoParameterException {
        if(parameters.get(name) == null) {
            throw new NoParameterException("getParameter: no parameter by name " + name);
        }
        else {
            return parameters.get(name);
        }
    }
}
