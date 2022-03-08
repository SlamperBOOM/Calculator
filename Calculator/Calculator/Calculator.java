package Calculator;
import java.io.*;
import java.util.*;

public class Calculator {
    private static Map<String, Double> parameters = new TreeMap<String, Double>();
    private static Map<String, String> operations = new TreeMap<String, String>();

    public static void instance(){
        BufferedReader definitions = null;
        try {
            definitions = new BufferedReader(new FileReader("src/Calculator/config.txt"));
            String line;
            while((line = definitions.readLine()) != null) {
                String[] conformissions = line.split(" ");
                operations.put(conformissions[0], conformissions[1]);
            }
            definitions.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
               if(definitions != null){
                   definitions.close();
               }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void addParameter(String name, Double value){
        parameters.put(name, value);
    }

    public static Double getParameter(String name){
        return parameters.get(name);
    }

    public static Operation getOperation(String name){
        Operation op = null;
        try{
            op = (Operation) Class.forName(operations.get(name)).newInstance();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return op;
    }

}
