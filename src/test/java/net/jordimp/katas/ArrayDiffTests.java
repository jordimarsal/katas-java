package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import net.jordimp.katas.arraydiff.ArrayDiff;

class ArrayDiffTests {

    @Test
    void arrayDiffTests() {
        System.out.println("****** ArrayDiffTests Basic Tests ******");
        assertArrayEquals(new int[] { 1, 3 }, ArrayDiff.arrayDiff(new int[] { 1, 2, 3 }, new int[] { 2, 4 }));
        assertArrayEquals(new int[] { 2 }, ArrayDiff.arrayDiff(new int[] { 1, 2 }, new int[] { 1 }));
        assertArrayEquals(new int[] { 2, 2 }, ArrayDiff.arrayDiff(new int[] { 1, 2, 2 }, new int[] { 1 }));
        assertArrayEquals(new int[] { 1 }, ArrayDiff.arrayDiff(new int[] { 1, 2, 2 }, new int[] { 2 }));
        assertArrayEquals(new int[] { 1, 2, 2 }, ArrayDiff.arrayDiff(new int[] { 1, 2, 2 }, new int[] {}));
        assertArrayEquals(new int[] {}, ArrayDiff.arrayDiff(new int[] {}, new int[] { 1, 2 }));
    }

}
