package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jordimp.katas.katas.basics.Basics;

class BasicsTest {

    @Test
    void testStringEnd() {
        System.out.println("****** StringEnd ******");
        assertEquals(true, Basics.StringEnd.isEnding("abc", "c"));
    }

    @Test
    void testSumNumbersBetween1() {
        System.out.println("****** SumNumbersBetween1 ******");
        assertEquals(6, Basics.SumNumbersBetween.getSum(0, 3));
    }

    @Test
    void testSumNumbersBetween2() {
        System.out.println("****** SumNumbersBetween2 ******");
        assertEquals(0, Basics.SumNumbersBetween.getSum(3, -3));
    }

    @Test
    void testNeedle() {
        System.out.println("****** Needle ******");
        assertEquals("found the needle at position 5",
            Basics.Needle.findNeedle(new Object[] { "hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk" }));
    }

    @Test
    void testDigitalization() {
        System.out.println("****** Digitalization ******");
        assertEquals("01110", Basics.Digitalization.digitalize("05671"));
    }

    @Test
    void testMapping() {
        assertArrayEquals(new int[] { 10, 12, 14 }, Basics.Mapping.doubling(new int[] { 5, 6, 7 }));
    }


    @Test
    void testBooleanCounter() {
        Boolean[] array1 = {true,  true,  true,  false,
            true,  true,  true,  true ,
            true,  false, true,  false,
            true,  false, false, true ,
            true,  true,  true,  true ,
            false, false, true,  true };
        assertEquals(17, Basics.BooleanCounter.countBooleans(array1));
        Boolean[] array2 = {true,  null,  true,  false,
            true,  true,  true,  true ,
            true,  false, true,  false,
            true,  false, false, true ,
            true,  true,  true,  true ,
            false, false, true,  true };
        assertEquals(16, Basics.BooleanCounter.countBooleans(array2));
    }

}

