package Calculator;

import Exceptions.CalculatorException;

import java.io.*;
import java.util.*;

public class Execution {
    public static void exec(Reader input){
        Calculator.instance();
        try {
            int symbol;
            boolean EOF = false;
            List<Double> stack = new ArrayList<Double>();
            while(true) {
                StringBuilder line = new StringBuilder();
                boolean commentline = false;
                while (true) {
                    symbol = input.read();
                    if(symbol == -1){
                        EOF = true;
                        break;
                    }
                    if(commentline && symbol == Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR
                            || commentline && symbol == Character.LINE_SEPARATOR)
                    {
                        commentline = false;
                        continue;
                    }
                    else if(commentline) {
                        continue;
                    }
                    else if(symbol == Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR || symbol == Character.LINE_SEPARATOR) {
                        break;
                    }
                    else if(symbol == '#')
                    {
                        commentline = true;
                        continue;
                    }
                    line.append((char)symbol);
                }
                if(line.length() == 0) {
                    continue;
                }
                String[] splitedline = line.toString().split(" ");
                Operation operation = Calculator.getOperation(splitedline[0]);
                List<String> arguments = new ArrayList<String>();
                if(splitedline.length != 1) {
                    for(int i = 1; i<splitedline.length; ++i) {
                        arguments.add(splitedline[i]);
                    }
                }
                try {
                    operation.calc(arguments, stack);
                }
                catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                }
                if(EOF){
                    break;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
