package calculator;
import exceptions.CalculatorException;

import java.util.List;

public interface Operation {
    List<Double> calc(List<String> arguments, List<Double> stack, Calculator calculator) throws CalculatorException;
}
