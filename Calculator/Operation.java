package Calculator;
import java.util.List;

public interface Operation {
    List<Double> calc(List<String> arguments, List<Double> stack);
}
