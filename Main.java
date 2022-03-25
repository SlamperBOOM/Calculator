import calculator.Calculator;
import calculator.CommandReader;
import exceptions.CalculatorException;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Reader input = null;
        Calculator calculator = new Calculator();
        try{
            if(args.length == 0){
                input = new InputStreamReader(System.in);
            }
            else
            {
                input = new InputStreamReader(new FileInputStream(args[0]));
            }
            while(true){
                String[] splitLine;
                try {
                    splitLine = CommandReader.readOperation(input);
                }catch (IOException e){
                    calculator.getLogger().logError(e);
                    continue;
                }
                if(splitLine[0].equals("")){
                    break;
                }
                try {
                    calculator.calculate(Arrays.asList(splitLine));
                }
                catch (CalculatorException e){
                    calculator.getLogger().logError(e);
                    System.err.println(e.getMessage());
                }
            }
        }
        catch (IOException e){
            calculator.getLogger().logError(e);
            e.printStackTrace();
        }
        finally {
            try{
                if(input != null) {
                    input.close();
                }
            }
            catch (IOException e){
                calculator.getLogger().logError(e);
                e.printStackTrace();
            }
        }
    }
}
