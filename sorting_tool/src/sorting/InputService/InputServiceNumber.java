package sorting.InputService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class InputServiceNumber<T extends Number & Comparable> extends InputService {

    public InputServiceNumber() {
        super();
    }

    public InputServiceNumber(File inputFile) throws FileNotFoundException {
        super(inputFile);
    }

    protected SortedSet<T> sortLongArrayByCounts(List<T> inputToSort, Map<T, Integer> inputElements) {
        SortedSet result = new TreeSet(new Comparator<T>() {
            @Override
            public int compare(T s, T t1) {
                int firstValue = (int) inputElements.get(s);
                int secondValue = (int) inputElements.get(t1);

                int comparatorValue = firstValue > secondValue ? 1 : -1;

                if (firstValue == secondValue)
                    comparatorValue = s.compareTo(t1);

                return comparatorValue;
            }
        });

        result.addAll(inputToSort);

        return result;
    }
}
