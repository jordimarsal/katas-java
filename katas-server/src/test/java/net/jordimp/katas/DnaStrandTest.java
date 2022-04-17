package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jordimp.katas.katas.basics.DnaStrand;

class DnaStrandTest {

    @Test
    void DnaTest() {
        System.out.println("****** DNA Tests ******");
        assertEquals("AAAA", DnaStrand.makeComplement("TTTT"));
        assertEquals("ATGC", DnaStrand.makeComplement("TACG"));
        assertEquals("GTAT", DnaStrand.makeComplement("CATA"));
        assertEquals("", DnaStrand.makeComplement(""));
    }

}
