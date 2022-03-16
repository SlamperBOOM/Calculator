package calculator;

import exceptions.NoConvertAvailableException;

import javax.lang.model.SourceVersion;
import java.util.*;

public class Value {
    private String value;

    public Value(String value){
        this.value = value;
    }

    public String toString(){
        return value;
    }

    public Double toDouble() throws NoConvertAvailableException {
        try{
            return Double.valueOf(value);
        }
        catch (NumberFormatException e){
            throw new NoConvertAvailableException("Value.toDouble: couldn't convert " + value + " to Double");
        }
    }

    public boolean isIdentifier(){
        return SourceVersion.isIdentifier(value);
    }

    public static List<Value> convertStringList(List<String> stringList){
        List<Value> valueList = new ArrayList<Value>();
        for(String element: stringList) {
            valueList.add(new Value(element));
        }
        return valueList;
    }
}
