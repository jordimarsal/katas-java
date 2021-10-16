package net.jordimp.katas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqInRect {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqInRect.class);

    private SqInRect() {
    }

    public static List<Integer> sqInRect(final int lenght, final int width) {

        if (lenght == width) {
            return Collections.emptyList();
        }
        Pair pair = getPair(lenght, width);
        final List<Integer> result = new ArrayList<>(Collections.singleton(pair.getMin()));

        while (pair.getMax() > 2 * pair.getMin()) {
            final int max = pair.getMax();
            final int min = pair.getMin();

            result.add(min);
            pair = getPair(max - min, min);
        }

        while (pair.getMax() - pair.getMin() > 0) {
            final int max = pair.getMax();
            final int min = pair.getMin();

            result.add(max - min);
            LOGGER.debug("{}", Math.min(pair.getMax() - pair.getMin(), pair.getMin()));
            pair = getPair(Math.min(pair.getMax() - pair.getMin(), pair.getMin()), pair.getMin());
        }

/*
        while (pair.getMax() - pair.getMin() > 0){
            int max = pair.getMax();
            int min = pair.getMin();

            if (min == 1){
                IntStream.range(1,max-1).map(i->i).collect(Collectors.toList());
            }
            result.add(max - min);
            pair = getPair(max - min, min);
        }
*/
        return result;
    }

    static Pair getPair(final int a, final int b) {
        return Pair.getInstance(a, b);
    }

}

class Pair {
    private static int max;
    private static int min;

    private static Pair instance;

    private Pair() {
    }

    static Pair getInstance(final int a, final int b) {
        max = Math.max(a, b);
        min = Math.min(a, b);
        if (instance == null) {
            instance = new Pair();
        }
        return instance;
    }

    public int getMax(){
        return max;
    }

    public int getMin(){
        return min;
    }
}
