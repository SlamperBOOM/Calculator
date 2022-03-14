package calculator;

import java.util.*;

public class Context {
    private List<Double> stack = new ArrayList<Double>();
    private Map<String, Double> parameters = new HashMap<String, Double>();

    public List<Double> getStack(){
        return stack;
    }

    public void addParameter(String name, Double value){
        parameters.put(name, value);
    }

    public Double getParameter(String name){
        return parameters.get(name);
    }
}
