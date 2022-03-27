package net.jordimp.katas.katas.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * @author jordi
 * Comparativa ArrayList vs LinkedList
 */
public class Performance {

    private static final int WARMUP = 1000;
    private static final int TEST = 1000;
    private static final int SIZE = 5000;

    private Performance() {
    }

    public static void perfTest() {
        // Warmup
        for (int i = 0; i < WARMUP; ++i) {
            buildArrayList();
        }
        // Test
        long sum1 = 0;
        for (int i = 0; i < TEST; ++i) {
            sum1 += buildArrayList();
        }
        log.info("Average time to build array list: " + (sum1 / TEST));

        long sum4 = 0;
        for (int i = 0; i < TEST; ++i) {
            sum4 += buildArrayList2();
        }
        log.info("Average time to build arraylist2: " + (sum4 / TEST));

        long sum11 = 0;
        List<Integer> al = getArrayList();
        for (int i = 0; i < TEST; ++i) {
            sum11 += getMidList(al);
        }
        log.info("Average time to get   arraylist : " + (sum11 / TEST));

        long sum2 = 0;
        for (int i = 0; i < TEST; ++i) {
            sum2 += buildArray();
        }
        log.info("Average time to build array     : " + (sum2 / TEST));

        long sum3 = 0;
        for (int i = 0; i < TEST; ++i) {
            sum3 += buildLinkedList();
        }
        log.info("Average time to build linkedlist: " + (sum3 / TEST));

        log.info("Average time to get  linkedlist : impracticable ");

        log.info("## END ##");

    }

    public static long buildArrayList() {
        final long start = System.nanoTime();
        final ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < SIZE; ++i) {
            a.add(i);
        }
        final long end = System.nanoTime();
        return end - start;
    }

    public static List<Integer> getArrayList() {
        final ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < SIZE; ++i) {
            a.add(i);
        }
        return a;
    }

    public static long getMidList(List<Integer> al) {
        final long start = System.nanoTime();
        for (int i = 0; i < SIZE; ++i) {
            int z = al.get(i);
        }
        final long end = System.nanoTime();
        return end - start;
    }

    public static long buildArrayList2() {
        final long start = System.nanoTime();
        final ArrayList<Integer> a = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; ++i) {
            a.add(i);
        }
        final long end = System.nanoTime();
        return end - start;
    }

    public static long buildArray() {
        final long start = System.nanoTime();
        final int[] a = new int[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            a[i] = i;
        }
        final long end = System.nanoTime();
        return end - start;
    }

    public static long buildLinkedList() {
        final long start = System.nanoTime();
        final LinkedList<Integer> a = new LinkedList<>();
        for (int i = 0; i < SIZE; ++i) {
            a.add(i);
        }
        final long end = System.nanoTime();
        return end - start;
    }

    public static List<Integer> getLinkedList() {
        final LinkedList<Integer> a = new LinkedList<>();
        for (int i = 0; i < SIZE; ++i) {
            a.add(i);
        }
        return a;
    }

    public static void main(final String[] args) {
        perfTest();
    }

}
