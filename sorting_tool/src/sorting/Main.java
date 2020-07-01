package sorting;

import sorting.InputService.InputService;
import sorting.InputService.InputServiceLines;
import sorting.InputService.InputServiceLong;
import sorting.InputService.InputServiceWord;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static InputService inputService;

    public static void main(final String[] args) {
        try {
            processArgs(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch(FileNotFoundException e) {
            System.out.println("No such file found. Exiting...");
            System.exit(1);
        }
    }

    private static void processArgs(String[] args) throws FileNotFoundException {
        String dataType = ParamTypes.DATA_TYPE_LONG;
        String sortType = ParamTypes.SORT_TYPE_NATURAL;
        String inputFileName = null, outputFileName = null;

        for (int i = 0; i < args.length; i++) {

            if (
                    (i > 0 && !ParamTypes.IO_PARAM_TYPES.contains(args[i - 1]))
                    &&
                    !ParamTypes.ALL_PARAM_TYPES.contains(args[i])
            ) {
                throw new IllegalArgumentException("\"" + args[i] + "\"" + " isn\'t a valid parameter. It's skipped");
            }

            if (args[i].equals(ParamTypes.PARAM_TYPE_DATA_TYPE)) {

                if (i + 1 == args.length)
                    throw new IndexOutOfBoundsException("No data type defined!");

                dataType = args[i + 1];
            }

            if (args[i].equals(ParamTypes.PARAM_TYPE_SORT_TYPE)) {

                if (i + 1 == args.length)
                    throw new IndexOutOfBoundsException("No sorting type defined!");

                sortType = args[i + 1];
            }

            if (args[i].equals(ParamTypes.PARAM_TYPE_INPUT_FILE)) {

                if (i + 1 == args.length)
                    throw new IndexOutOfBoundsException("No input file defined!");

                inputFileName = args[i + 1];
            }

            if (args[i].equals(ParamTypes.PARAM_TYPE_OUTPUT_FILE)) {

                if (i + 1 == args.length)
                    throw new IndexOutOfBoundsException("No input file defined!");

                outputFileName = args[i + 1];
            }
        }

        if (inputFileName != null) {
            processGetInfo(dataType, inputFileName);

        } else {
            processGetInfo(dataType);
        }

        if (outputFileName != null) {
            inputService.setWriter(outputFileName);
        } else {
            inputService.setWriter();
        }

        processOutput(sortType);
    }

    private static void processGetInfo(String dataType) {
        switch(dataType) {
            case ParamTypes.DATA_TYPE_WORD:
                inputService = new InputServiceWord();
                break;
            case ParamTypes.DATA_TYPE_LONG:
                inputService = new InputServiceLong();
                break;
            case ParamTypes.DATA_TYPE_LINES:
                inputService = new InputServiceLines();
                break;
            default:
                break;
        }
    }

    private static void processGetInfo(String dataType, String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        switch(dataType) {
            case ParamTypes.DATA_TYPE_WORD:
                inputService = new InputServiceWord(file);
                break;
            case ParamTypes.DATA_TYPE_LONG:
                inputService = new InputServiceLong(file);
                break;
            case ParamTypes.DATA_TYPE_LINES:
                inputService = new InputServiceLines(file);
                break;
            default:
                break;
        }
    }

    private static void processOutput(String sortType) {
        if (sortType.equals(ParamTypes.SORT_TYPE_NATURAL)) {
            inputService.consoleOutput();
        } else {
            inputService.consoleOutputByCount();
        }
    }
}
