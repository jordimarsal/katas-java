package net.jordimp.katas.katas.arrays;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class MaxSubarraySum {

    private MaxSubarraySum() {
    }
    // The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or
    // list of integers:
    //
    // "Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});"
    // "should be 6: {4, -1, 2, 1}"
    // Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
    // If the list is made up of only negative numbers, return 0 instead.
    //
    // Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid
    // sublist/subarray.

    public static int sequence(final int[] arr) {

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = innerSum(i, arr, res);
        }
        return Math.max(res, 0);
    }

    static int innerSum(final int initial, final int[] arr, int res) {

        for (int minor = 0; minor < arr.length; minor++) {
            int sum = 0;
            for (int i = initial; i < arr.length - minor; i++) {
                sum += arr[i];
            }
            if (sum > res) {
                res = sum;
            }
        }
        return res;
    }

    public static int sequenceWStreams(final int[] arr) {
        final int[] max = { 0 };

        // @formatter:off
        return stream(arr)
            .map(i -> i = max[0] = Math.max(i + max[0], 0))
            .max()
            .orElse(0);
        // @formatter:on
    }

    public static int sequenceRange(final int[] array) {
        // @formatter:off
        return range(0, array.length)
            .flatMap(start -> range(1, array.length - start + 1)
                .map(subLength -> stream(array).skip(start).limit(subLength).sum()))
            .filter(sum -> sum >= 0)
            .max().orElse(0);
        // @formatter:on
    }

}
