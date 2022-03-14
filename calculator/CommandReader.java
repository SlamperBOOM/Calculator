package calculator;

import java.io.*;

public class CommandReader {
    public static String[] readOperation(Reader input){
        String[] command = {""};
        try {
            int symbol;
            StringBuilder line = new StringBuilder();
            boolean commentLine = false;
            while (true) {
                symbol = input.read();
                if (symbol == -1) {
                    break;
                }
                if (commentLine &&
                        (symbol == Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR || symbol == Character.LINE_SEPARATOR)) {
                    commentLine = false;
                    continue;
                } else if (commentLine) {
                    continue;
                } else if ((symbol == Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR || symbol == Character.LINE_SEPARATOR) && line.length() == 0) {
                    continue;
                } else if(symbol == Character.DIRECTIONALITY_PARAGRAPH_SEPARATOR || symbol == Character.LINE_SEPARATOR){
                    break;
                } else if (symbol == '#') {
                    commentLine = true;
                    continue;
                }
                line.append((char) symbol);
            }
            command = line.toString().split(" ");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return command;
    }
}
