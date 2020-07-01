package sorting.InputService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class InputServiceStrings extends InputService {

    public InputServiceStrings(File inputFile) throws FileNotFoundException {
        super(inputFile);
    }

    public InputServiceStrings() {
        super();
    }

        protected static Comparator<String> comparatorString = new Comparator<String>() {
        @Override
        public int compare(String s, String t1) {
            int sortNumber = 0;
            int result = 0;

            if (s.length() == t1.length()) {
                sortNumber = s.compareTo(t1);
                result = sortNumber > 0 ? 1 : sortNumber < 0 ? -1 : 0;
            }
            else {
                result = s.length() > t1.length() ? 1 : -1;
            }

            return result;
        }
    };

    protected SortedSet<String> sortArrayByCounts(List<String> inputToSort, Map<String, Integer> inputElements) {
        SortedSet result = new TreeSet(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                int firstValue = (int) inputElements.get(s);
                int secondValue = (int) inputElements.get(t1);

                int comparatorValue = 0;

                if (firstValue == secondValue) {
                    int sortNumber = s.compareTo(t1);
                    comparatorValue = sortNumber > 0 ? 1 : sortNumber < 0 ? -1 : 0;
                } else {
                    comparatorValue = firstValue > secondValue ? 1 : -1;
                }

                return comparatorValue;
            }
        });

        result.addAll(inputToSort);

        return result;
    }
}
