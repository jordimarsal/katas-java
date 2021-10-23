package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import net.jordimp.katas.streams.RecycleStream;

class RecycleStreamTests {

    String text = """
        ### header
        ### header
        jump
        1,2,3,4,5,6
        0,0,0,0,0,0
        1,2,3,4,5,6
        0,0,0,0,0,0
        1,2,3,4,5,6
        0,0,0,0,0,0
        1,2,3,4,5,6
        0,0,0,0,0,0
        """;

    @Test
    void recycleStreamTest() {
        System.out.println("****** RecycleStreamTests ******");
        assertArrayEquals(new int[] { 3, 3, 3, 3 }, RecycleStream.extract(this.text));

    }

}
