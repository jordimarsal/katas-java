package net.jordimp.katas.katas;

import java.util.Arrays;

public class Persist {

    private Persist() {
    }

    public static int persistence(final long n) {

        final String[] str = String.valueOf(n).split("");
        if (str.length == 1) {
            return 0;
        }
        return persistence(
            // @formatter:off
            Arrays.stream(str)
                .map(Integer::parseInt)
                .reduce(1, (a, b) -> a * b)
            // @formatter:on
        ) + 1;
    }

}
