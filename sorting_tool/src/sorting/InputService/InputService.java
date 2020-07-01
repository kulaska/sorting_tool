package sorting.InputService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class InputService<T> {

    public InputService(File inputFile) throws FileNotFoundException {
        scanner = new Scanner(inputFile);
    }

    public InputService() {
        scanner = new Scanner(System.in);
    }

    public enum dataTypes {
        LONG, WORD, LINES
    }

    protected Map<T, Integer> inputElements;
    protected SortedSet<T> sortedElements;

    protected Scanner scanner;
    protected OutputService outputService;

    protected int counterAll = 0;

    protected dataTypes type;

    protected abstract void outputData();

    protected abstract void outputDataByCount();

    public abstract void processInputElements();

    public void consoleOutput() {
        outputData();
    }

    public void consoleOutputByCount() { outputDataByCount(); }

    public void setWriter() {
        outputService = new OutputService();
    }

    public void setWriter(String outFilePath) throws FileNotFoundException {
        File outFile = new File(outFilePath);
        outputService = new OutputService(outFile);
    }

    protected int calculateRatio(int counterTimesNumber) {
        return Math.round(((float) counterTimesNumber / (float) counterAll) * 100);
    }
}
