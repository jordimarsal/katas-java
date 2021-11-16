package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jordimp.katas.katas.basics.Questions;

 class QuestionsTest {

    @Test
    void questionTests() {
        System.out.println("****** QuestionTests ******");
        assertEquals("0\n-32 -7", Questions.operations());
    }

    @Test
    void segmentTests() {
        System.out.println("****** QuestionTests ******");
        assertEquals("", Questions.segments());
    }

}
