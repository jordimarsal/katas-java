package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jordimp.katas.katas.SequenceSum;

class SequenceSumTest {

    @Test
    void sequenceSumTests() {
        System.out.println("****** SequenceSumTest ******");
        assertEquals("0+1+2+3+4+5+6 = 21", SequenceSum.showSequence(6));
        assertEquals("0=0", SequenceSum.showSequence(0));
        assertEquals("-15<0", SequenceSum.showSequence(-15));
    }

}
