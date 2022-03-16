package calculator;

import exceptions.CalculatorException;

import java.io.*;
import java.util.logging.*;
import java.util.*;

public class CalculatorLogger {
    private Logger logger;

    public CalculatorLogger(){
        logger = Logger.getLogger(this.getClass().getName());
        try {
            logger.addHandler(new FileHandler("src/calculator/log.log"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void logInfo(List<String> command, List<Double> oldStack, List<Double> newStack){
        StringBuilder message = new StringBuilder();
        message.append(command.get(0)).append(" ");
        if(command.size() == 3){ //only define
            message.append(command.get(1)).append(" as ").append(command.get(2));
        }else if(command.size() == 2){ //only push
            message.append(command.get(1)).append(" to stack");
        }else{
            if(command.get(0).equals("pop")){
                message.append(oldStack.get(oldStack.size() - 1)).append(" from stack");
            } else if(command.get(0).equals("print")){
                message.append(oldStack.get(oldStack.size() - 1));
            } else if(command.get(0).equals("sqrt")){
                message.append(oldStack.get(oldStack.size() - 1)).append(". put ")
                        .append(newStack.get(newStack.size() - 1)).append(" in stack");
            } else{
                message.append(oldStack.get(oldStack.size() - 2)).append(" and ")
                        .append(oldStack.get(oldStack.size() - 1)).append(". put ")
                        .append(newStack.get(newStack.size() - 1)).append(" in stack");
            }
        }
        logger.info(message.toString());
    }

    public void logError(CalculatorException exception){
        logger.severe(exception.getClass().getName() + " " + exception.getMessage());
    }
}
