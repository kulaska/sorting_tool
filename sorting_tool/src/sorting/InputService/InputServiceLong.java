package sorting.InputService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InputServiceLong extends InputServiceNumber {

    public InputServiceLong() {
        super();

        type = dataTypes.LONG;
        processInputElements();
    }

    public InputServiceLong(File inputFile) throws FileNotFoundException {
        super(inputFile);

        type = dataTypes.LONG;
        processInputElements();
    }

    @Override
    public void processInputElements() {
        Map<Long, Integer> input = new TreeMap<>();
        List<Long> sortedInput = new ArrayList<>();

        while (scanner.hasNextLong()) {
            Long number;
            number = scanner.nextLong();

            int value = input.getOrDefault(number, 0);
            input.put(number, ++value);

            sortedInput.add(number);

            counterAll++;
        }

        sortedElements = sortLongArrayByCounts(sortedInput, input);
        inputElements = input;
    }

    @Override
    protected void outputData() {
        outputService.println("Total numbers: " + counterAll + ".");
        outputService.print("Sorted data:");

        inputElements.forEach((element, numberOfTimes) -> {
            for (int i = 0; i < (int) numberOfTimes; i++)
                outputService.print(" " + element);
        });
    }

    @Override
    protected void outputDataByCount() {
        outputService.println("Total numbers: " + counterAll + ".");

        for (Object element : sortedElements) {
            outputService.println(element + ": " + inputElements.get(element) + " time(s), " + calculateRatio((Integer) inputElements.get(element)) + "%");
        }
    }
}
