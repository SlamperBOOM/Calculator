package exceptions;

public class TooSmallStackException extends CalculatorException{
    public TooSmallStackException(String message, int stacksize){
        super(message + String.valueOf(stacksize));
    }
}
