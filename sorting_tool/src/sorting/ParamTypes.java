package sorting;

import java.util.Arrays;
import java.util.List;

public final class ParamTypes {
    public static final String PARAM_TYPE_DATA_TYPE = "-dataType";
    public static final String PARAM_TYPE_SORT_TYPE = "-sortingType";
    public static final String PARAM_TYPE_INPUT_FILE = "-inputFile";
    public static final String PARAM_TYPE_OUTPUT_FILE = "-outputFile";

    public static final String SORT_TYPE_NATURAL = "natural";
    public static final String SORT_TYPE_BY_COUNT = "byCount";
    public static final String DATA_TYPE_WORD = "word";
    public static final String DATA_TYPE_LINES = "line";
    public static final String DATA_TYPE_LONG = "long";

    public static final String EMPTY = "";

    public static final List<String> IO_PARAM_TYPES = Arrays.asList(
            PARAM_TYPE_INPUT_FILE,
            PARAM_TYPE_OUTPUT_FILE
    );

    public static final List<String> ALL_PARAM_TYPES = Arrays.asList(
            PARAM_TYPE_DATA_TYPE,
            PARAM_TYPE_SORT_TYPE,
            PARAM_TYPE_OUTPUT_FILE,
            PARAM_TYPE_INPUT_FILE,
            SORT_TYPE_NATURAL,
            SORT_TYPE_BY_COUNT,
            DATA_TYPE_WORD,
            DATA_TYPE_LINES,
            DATA_TYPE_LONG,
            EMPTY
    );
}

