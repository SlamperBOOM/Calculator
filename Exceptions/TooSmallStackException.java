package Exceptions;

public class TooSmallStackException extends Exception{
    public TooSmallStackException(String message, int stacksize){
        super(message + String.valueOf(stacksize));
    }
}
