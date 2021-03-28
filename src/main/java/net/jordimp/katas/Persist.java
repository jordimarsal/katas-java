package net.jordimp.katas;

import java.util.Arrays;

public class Persist {
    public static int persistence(long n) {
        String str[] = String.valueOf(n).split("");
        if (str.length==1) return 0;
        return persistence(
                Arrays.stream(str)
                        .map(Integer::parseInt)
                        .reduce(1, (a, b) -> a * b)
        )+1;
    }
}
