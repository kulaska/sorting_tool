package sorting.InputService;

import java.io.*;
import java.util.*;

public class InputServiceWord extends InputServiceStrings {
    
    public InputServiceWord() {
        super();
        type = dataTypes.WORD;
        processInputElements();
    }

    public InputServiceWord(File inputFile) throws FileNotFoundException {
        super(inputFile);
        type = dataTypes.WORD;
        processInputElements();
    }

    @Override
    public void processInputElements() {
        Map<String, Integer> input = new TreeMap<>(comparatorString);
        List<String> sortedInput = new ArrayList<>();

        while (scanner.hasNext()) {
            String word = scanner.next();

            int value = input.getOrDefault(word, 0);
            input.put(word, ++value);

            sortedInput.add(word);

            counterAll++;
        }

        sortedElements = sortArrayByCounts(sortedInput, input);
        inputElements = input;
    }

    @Override
    protected void outputData() {
        outputService.println("Total words: " + counterAll + ".");
        outputService.print("Sorted data:");

        inputElements.forEach((element, numberOfTimes) -> {
            for (int i = 0; i < (int) numberOfTimes; i++)
                outputService.print(" " + element);
        });
    }

    @Override
    protected void outputDataByCount() {
        outputService.println("Total words: " + counterAll + ".");

        for (Object element : sortedElements) {
            outputService.println(element + ": " + inputElements.get(element) + " time(s), " + calculateRatio((Integer) inputElements.get(element)) + "%");
        }
    }
}
