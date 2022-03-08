package Operations;

import Calculator.Operation;
import java.util.List;

public class Print implements Operation {
    @Override
    public List<Double> calc(List<String> arguments, List<Double> stack){
        if(stack.size() == 0) {
            System.out.println("Nothing to print");
        }
        else {
            System.out.println(stack.get(stack.size() - 1));
        }
        return stack;
    }
}
