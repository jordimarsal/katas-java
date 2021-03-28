package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


class SqInRectTest {

    @Test
    void test1() {
        List<Integer> res = new ArrayList<>(Arrays.asList(3, 2, 1, 1));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(5, 3));
    }
    @Test
    void test2() {
        List<Integer> res = new ArrayList<>(Arrays.asList(5, 3, 1, 1, 1));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(7, 4));
    }
    @Test
    void test3() {
        List<Integer> res = new ArrayList<>(Arrays.asList(5, 5, 3, 2, 1));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(13, 5));
    }
    @Test
    void testk() {
        assertEquals(null, SqInRect.sqInRect(5, 5));
    }
}
