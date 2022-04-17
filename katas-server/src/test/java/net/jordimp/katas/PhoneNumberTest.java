package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jordimp.katas.dto.PhoneNumber;
import net.jordimp.katas.katas.basics.DnaStrand;

class PhoneNumberTest {

    @Test
    void PhoneTest() {
        System.out.println("****** Phone Number Tests ******");
        assertEquals("+23", PhoneNumber.of("+23-456-7890").countryCode());
        assertEquals("456", PhoneNumber.of("+23-456-7890").areaCode());
        assertEquals("7890", PhoneNumber.of("+23-456-7890").subscriberNumber());
        assertEquals("+23-456-7890", PhoneNumber.of("+23-456-7890").toString());
    }

}
