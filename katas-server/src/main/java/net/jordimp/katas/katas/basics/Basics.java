package net.jordimp.katas.katas.basics;

import java.util.Arrays;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Basics {

    private Basics() {
    }

    public static class StringEnd {

        private StringEnd() {
        }

        public static boolean isEnding(final String str, final String end) {
            return str.endsWith(end);
        }

    }

    public static class SumNumbersBetween {

        private SumNumbersBetween() {
        }
        /*
        Given two integers a and b, which can be positive or negative,
         find the sum of all the integers between and including them and return it.
         If the two numbers are equal return a or b.
        Note: a and b are not ordered!
         */

        public static int getSum(final int a, final int b) {
            if (a == b) {
                return a;
            }
            if (a > b) {
                return getSum(b, a);
            }
            return a + getSum(a + 1, b);
        }

    }

    public static class Needle {

        private Needle() {
        }

        /*
        Write a function findNeedle() that takes an array full of junk but containing one "needle"
        After your function finds the needle it should return a message (as a string) that says:
        "found the needle at position " plus the index it found the needle, so:

        findNeedle(new Object[]{"hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"})
        should return "found the needle at position 5"
        */
        public static String findNeedle(final Object[] haystack) {
            for (int i = 0; i < haystack.length; i++) {
                if (haystack[i].equals("needle")) {
                    return "found the needle at position " + i;
                }
            }
            return "";
        }

    }

    public static class Digitalization {

        private Digitalization() {
        }

        public static String digitalize(final String numberString) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numberString.length(); i++) {
                if (Integer.parseInt(Character.toString(numberString.charAt(i))) < 5) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
            return sb.toString();
        }

    }

    public static class Mapping {

        private Mapping() {
        }

        public static int[] doubling(final int[] arr) {
            return Arrays.stream(arr).map(i -> i * 2).toArray();
        }

    }

    public static class BooleanCounter {

        private BooleanCounter() {
        }

        public static int countBooleans(final Boolean[] arr) {
            return (int) Arrays.stream(arr)
                .filter(Boolean.TRUE::equals)
                //.filter(b -> b != null && b)
                .count();
        }

    }

    public static class RandomFlaw {

        static Random random = new Random();

        static int rand(int n) {
            return Math.abs(random.nextInt()) % n;
        }
        private RandomFlaw() {
        }

        public static int third() {
            int n= 2 * (Integer.MAX_VALUE / 3);
            int low = 0;
            for (int i = 0; i < 10_000_000; i++) {
                if (rand(n) < n / 2) {
                    low++;
                }
            }
            log.info(String.valueOf(low));
            return low;
        }

    }

    public static class OneDimensionDistance {

        private OneDimensionDistance() {
        }

        public static int getLeastDistance(final int u, final int x, final int y) {
            return Math.min(Math.abs(u - x), Math.abs(u - y));
        }

    }

}

