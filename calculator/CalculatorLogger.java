package calculator;

import java.io.*;
import java.util.logging.*;
import java.util.*;

public class CalculatorLogger {
    private Logger logger;

    public CalculatorLogger(){
        logger = Logger.getLogger(this.getClass().getName());
        try {
            logger.addHandler(new FileHandler("src/calculator/logging/log.log"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void logOperation(List<String> command, List<Double> oldStack, List<Double> newStack){
        StringBuilder message = new StringBuilder();
        message.append(command.get(0)).append(" ");
        if(command.size() == 3){ //only define
            message.append(command.get(1)).append(" as ").append(command.get(2));
        }else if(command.size() == 2){ //only push
            message.append(command.get(1)).append(" to stack");
        }else{
            switch (command.get(0)) {
                case "pop" -> message.append(oldStack.get(oldStack.size() - 1)).append(" from stack");
                case "print" -> message.append(oldStack.get(oldStack.size() - 1));
                case "sqrt" -> message.append(oldStack.get(oldStack.size() - 1)).append(". put ")
                        .append(newStack.get(newStack.size() - 1)).append(" in stack");
                default -> message.append(oldStack.get(oldStack.size() - 2)).append(" and ")
                        .append(oldStack.get(oldStack.size() - 1)).append(". put ")
                        .append(newStack.get(newStack.size() - 1)).append(" in stack");
            }
        }
        logger.info(message.toString());
    }

    public void logError(Exception exception){
        StackTraceElement[] stackTrace = exception.getStackTrace();
        StringBuilder message = new StringBuilder();
        for(StackTraceElement elem: stackTrace) {
            message.append(elem.toString()).append(", ");
        }
        message.append("\n").append(exception.getClass().getName()).append(" ").append(exception.getMessage());
        logger.severe(message.toString());
    }

    public void logInitialization(String message){
        logger.info(message);
    }
}
