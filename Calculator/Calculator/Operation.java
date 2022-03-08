package Calculator;
import Exceptions.EmptyStackException;
import Exceptions.ImpossibleCalculationException;
import Exceptions.TooSmallStackException;

import java.util.List;

public interface Operation {
    List<Double> calc(List<String> arguments, List<Double> stack) throws EmptyStackException,
            TooSmallStackException, ImpossibleCalculationException;
}
