import calculator.Execution;
import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String args[]){
        Reader input = null;
        try{
            if(args.length == 0){
                input = new InputStreamReader(System.in);
            }
            else
            {
                input = new InputStreamReader(new FileInputStream(args[0]));
            }
            Execution.exec(input);
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
