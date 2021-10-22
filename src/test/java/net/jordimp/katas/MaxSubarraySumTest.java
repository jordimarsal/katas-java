package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jordimp.katas.arrays.MaxSubarraySum;

class MaxSubarraySumTest {

    @Test
    void arrayDiffTests() {
        System.out.println("****** MaxSubarraySumTest Basic Tests ******");
        assertEquals(6, MaxSubarraySum.sequence(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    @Test
    void testsequenceWStreams(){
        assertEquals(6, MaxSubarraySum.sequenceWStreams(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    @Test
    void testsequenceRange(){
        assertEquals(6, MaxSubarraySum.sequenceRange(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

}
