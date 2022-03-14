package calculator;
import exceptions.CalculatorException;

import java.util.List;

public interface Operation {
    void calc(List<Value> arguments, Context context) throws CalculatorException;
}
