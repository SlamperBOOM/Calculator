package calculator;

import exceptions.CalculatorException;
import exceptions.NoSuchOperationException;
import java.util.*;
import java.io.*;

public class OperationsCreator {
    public Map<String, String> operations = new HashMap<String, String>();

    public OperationsCreator(){
        readOperations();
    }

    private void readOperations(){
        BufferedReader config = null;
        try{
            config = new BufferedReader(new FileReader("src/calculator/config.conf"));
            String line;
            while((line = config.readLine()) != null) {
                String[] conformissions = line.split(" ");
                operations.put(conformissions[0], conformissions[1]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                if (config != null){
                    config.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public Operation getOperation(String name) throws CalculatorException {
        Operation op = null;
        try{
            if(operations.get(name) == null){
                throw new NoSuchOperationException("There is no operation called " + name);
            }
            op = (Operation) Class.forName(operations.get(name)).newInstance();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (NoSuchOperationException e){
            System.out.println(e.getMessage());
        }
        return op;
    }
}
