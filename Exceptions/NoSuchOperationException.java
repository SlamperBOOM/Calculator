package Exceptions;

public class NoSuchOperationException extends CalculatorException{
    public NoSuchOperationException(String message){
        super(message);
    }
}
