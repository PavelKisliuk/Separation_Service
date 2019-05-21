package biz.pavelkisliuk.separationservice.sorter;

import biz.pavelkisliuk.separationservice.exception.CustomException;
import biz.pavelkisliuk.separationservice.model.TextComponent;
import biz.pavelkisliuk.separationservice.reader.SeparationFileReader;
import biz.pavelkisliuk.separationservice.separator.IdentSeparator;
import biz.pavelkisliuk.separationservice.separator.TextSeparatorChain;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WordSortTest {

	@Test
	public void testSort() throws CustomException {
		SeparationFileReader fileReader = new SeparationFileReader();
		TextSeparatorChain separator = new IdentSeparator();
		TextComponent actual = separator.separate(fileReader.readToString("testfile/Wordsort.txt"));
		TextComponent expected = separator.separate(fileReader.readToString("testfile/ExpectedWordSort.txt"));

		new WordSort().sort(actual);
		assertEquals(actual, expected);
	}
}