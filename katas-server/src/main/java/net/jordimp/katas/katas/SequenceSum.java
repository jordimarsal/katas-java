package net.jordimp.katas.katas;

import static java.lang.String.format;

import java.util.stream.IntStream;

public class SequenceSum {

    private SequenceSum() {
    }

    static StringBuilder sb = new StringBuilder();

    // We want to generate a function that computes the series starting from 0 and ending until the given number.
    // Input:
    //     > 6
    // Output:
    //     0+1+2+3+4+5+6 = 21
    // Input:
    //     > -15
    // Output:
    //     -15<0
    // Input:
    //     > 0
    // Output:
    //     0=0

    public static String showSequence(final int value) {

        if (value == 0) {
            return "0=0";
        }
        if (value < 0) {
            return format("%d<0", value);
        }

        IntStream.range(0, value + 1).forEach(SequenceSum::str);
        final int sum = IntStream.range(0, value + 1).sum();
        sb.append(" = ").append(sum);

        return sb.toString();
    }

    private static void str(final int n) {
        if (sb.length() == 0) {
            sb.append(n);
        } else {
            sb.append("+").append(n);
        }
    }

}
