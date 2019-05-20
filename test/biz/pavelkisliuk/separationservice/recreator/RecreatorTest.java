package biz.pavelkisliuk.separationservice.recreator;

import biz.pavelkisliuk.separationservice.separator.TextSeparatorChain;
import biz.pavelkisliuk.separationservice.separator.IdentSeparator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RecreatorTest {

	@Test
	public void testRecreate() {
		String expected = "\tHi!.. My name is... Why? My name is!..\n" +
				"\tYou are never. Ever. Have a. Friend like me!";
		TextSeparatorChain separator = new IdentSeparator();
		assertEquals(new Recreator().recreate(separator.separate(expected)), expected);
	}
}