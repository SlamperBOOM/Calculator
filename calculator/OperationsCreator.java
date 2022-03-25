package calculator;

import exceptions.CalculatorException;
import exceptions.NoSuchOperationException;
import java.util.*;
import java.io.*;

public class OperationsCreator {
    public Map<String, String> operations = new HashMap<String, String>();

    public void readOperations(CalculatorLogger logger){
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
            logger.logError(e);
            e.printStackTrace();
        }
        finally {
            try {
                if (config != null){
                    config.close();
                }
            }
            catch (IOException e){
                logger.logError(e);
                e.printStackTrace();
            }
        }
    }

    public Operation getOperation(String name) throws CalculatorException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Operation op = null;
        if(operations.get(name) == null){
            throw new NoSuchOperationException("getOperation: there is no operation called " + name);
        }
        op = (Operation) Class.forName(operations.get(name)).newInstance();
        return op;
    }
}
