package net.jordimp.katas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SqInRect {

    public static List<Integer> sqInRect(int lenght, int width) {

        if (lenght == width) return null;
        Pair pair = getPair(lenght, width);
        List<Integer> result = new ArrayList<>(Collections.singleton(pair.getMin()));

        while (pair.getMax() - pair.getMin() > 0){
            result.add(pair.getMax() - pair.getMin());
            System.out.println(Math.min(pair.getMax() - pair.getMin(),pair.getMin()) );
            pair = getPair(Math.min(pair.getMax() - pair.getMin(),pair.getMin()) , pair.getMin() );
        }

        return result;
    }

    static Pair getPair(int a, int b){
        return Pair.getInstance(a, b);
    }

}

class Pair {
    private static int max;
    private static int min;

    private static Pair instance;

    private Pair() {
    }

    static Pair getInstance(int a, int b){
        max = Math.max(a, b);
        min = Math.min(a, b);
        if (instance == null){
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
