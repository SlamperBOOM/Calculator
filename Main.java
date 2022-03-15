import calculator.Calculator;
import calculator.CommandReader;
import exceptions.CalculatorException;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Reader input = null;
        try{
            if(args.length == 0){
                input = new InputStreamReader(System.in);
            }
            else
            {
                input = new InputStreamReader(new FileInputStream(args[0]));
            }
            Calculator calculator = new Calculator();
            while(true){
                String[] splitLine = CommandReader.readOperation(input);
                if(splitLine[0].equals("")){
                    System.out.println("End of input");
                    break;
                }
                try {
                    calculator.calculate(Arrays.asList(splitLine));
                }
                catch (CalculatorException e){
                    System.err.println(e.getMessage());
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(input != null) {
                    input.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
