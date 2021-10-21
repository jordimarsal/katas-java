package net.jordimp.katas.arraydiff;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayDiff {

    private ArrayDiff() {
    }

    // Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
    // It should remove all values from list a, which are present in list b keeping their order.
    // "Kata .arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}"
    // If a value is present in b, all of its occurrences must be removed from the other:
    // "Kata .arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}"

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayDiff.class);

    public static int[] arrayDiff(final int[] a, final int[] b) {

        // @formatter:off
        final int[] res = Arrays.stream(a)
            .filter(number -> !contains(b, number))
            .toArray();
        // @formatter:on

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(Arrays.toString(res));
        }
        return res;
    }

    private static boolean contains(final int[] b, final int elem) {
        return Arrays.stream(b).anyMatch(s -> s == elem);
    }

}
