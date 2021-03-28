package net.jordimp.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


class PersistTests {

	@Test
	void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals(3, Persist.persistence(39));
		assertEquals(0, Persist.persistence(4));
		assertEquals(2, Persist.persistence(25));
		assertEquals(4, Persist.persistence(999));
	}

}
