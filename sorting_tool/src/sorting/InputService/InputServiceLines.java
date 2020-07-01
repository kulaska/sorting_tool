package sorting.InputService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InputServiceLines extends InputServiceStrings {

    public InputServiceLines() {
        super();
        type = dataTypes.LINES;
        processInputElements();
    }

    public InputServiceLines(File inputFile) throws FileNotFoundException {
        super(inputFile);
        type = dataTypes.LINES;
        processInputElements();
    }

    @Override
    public void processInputElements() {
        Map<String, Integer> input = new TreeMap<>(comparatorString);
        List<String> sortedInput = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();

            int value = input.getOrDefault(str, 0);
            input.put(str, ++value);

            sortedInput.add(str);

            counterAll++;
        }

        sortedElements = sortArrayByCounts(sortedInput, input);
        inputElements = input;
    }


    @Override
    protected void outputData() {
        outputService.println("Total lines: " + counterAll + ".");
        outputService.print("Sorted data:");

        inputElements.forEach((element, numberOfTimes) -> {
            for (int i = 0; i < (int) numberOfTimes; i++)
                outputService.print(" " + element);
        });
    }

    @Override
    protected void outputDataByCount() {
        outputService.println("Total lines: " + counterAll + ".");

        for (Object element : sortedElements) {
            outputService.println(element + ": " + inputElements.get(element) + " time(s), " + calculateRatio((Integer) inputElements.get(element)) + "%");
        }
    }
}
