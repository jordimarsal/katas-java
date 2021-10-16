package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SqInRectTest {

    @Test
    void test1() {
        final List<Integer> res = new ArrayList<>(Arrays.asList(3, 2, 1, 1));
        for (final int r : res) {
            assertEquals(res, SqInRect.sqInRect(5, 3));
        }
    }

    @Disabled("Not impl")
    @Test
    void test2() {
        final List<Integer> res = new ArrayList<>(Arrays.asList(4, 3, 1, 1, 1));
        for (final int r : res) {
            assertEquals(res, SqInRect.sqInRect(7, 4));
        }
    }

    @Test
    void test3() {
        final List<Integer> res = new ArrayList<>(Arrays.asList(5, 5, 3, 2, 1, 1));
        for (final int r : res) {
            assertEquals(res, SqInRect.sqInRect(13, 5));
        }
    }

    @Test
    void test4() {
        final List<Integer> res = new ArrayList<>(Arrays.asList(5, 5, 5, 3, 2, 1, 1));
        for (final int r : res) {
            assertEquals(res, SqInRect.sqInRect(18, 5));
        }
    }

    @Disabled("Not impl")
    @Test
    void testk() {
        assertNull(SqInRect.sqInRect(5, 5));
    }

}
