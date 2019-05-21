package biz.pavelkisliuk.separationservice.recreator;

import biz.pavelkisliuk.separationservice.separator.TextSeparatorChain;
import biz.pavelkisliuk.separationservice.separator.IdentSeparator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RecreatorTest {
	Recreator recreator = new Recreator();

	@Test
	public void testRecreateNull() {
		assertEquals(recreator.recreate(null), "");
	}

	@Test
	public void testRecreate() {
		String expected = "\tHi!.. My name is... Why? My name is!..\n" +
				"\tYou are never. Ever. Have a. Friend like me!";
		TextSeparatorChain separator = new IdentSeparator();
		assertEquals(recreator.recreate(separator.separate(expected)), expected);
	}
}