package sorting.InputService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OutputService {

    PrintWriter writer = null;

    public OutputService(File fileName) throws FileNotFoundException {
        writer = new PrintWriter(fileName);
    }

    public OutputService() {};

    private void printLineToConsole(String str) {
        System.out.println(str);
    }

    private void printLineToFile(String str) {
        writer.println(str);
    }

    private void printToConsole(String str) {
        System.out.print(str);
    }

    private void printToFile(String str) {
        writer.print(str);
    }

    public void println(String stringToOutput) {
        if (writer == null) {
            printLineToConsole(stringToOutput);
        } else {
            printLineToFile(stringToOutput);
        }
    }

    public void print(String stringToOutput) {
        if (writer == null) {
            printToConsole(stringToOutput);
        } else {
            printToFile(stringToOutput);
        }
    }
}
