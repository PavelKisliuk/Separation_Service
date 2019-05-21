package biz.pavelkisliuk.separationservice.sorter;

import biz.pavelkisliuk.separationservice.exception.CustomException;
import biz.pavelkisliuk.separationservice.model.TextComponent;
import biz.pavelkisliuk.separationservice.reader.SeparationFileReader;
import biz.pavelkisliuk.separationservice.separator.IdentSeparator;
import biz.pavelkisliuk.separationservice.separator.TextSeparatorChain;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceSortTest {

	@Test
	public void testSort() throws CustomException {
		SeparationFileReader fileReader = new SeparationFileReader();
		TextSeparatorChain separator = new IdentSeparator();
		TextComponent actual = separator.separate(fileReader.readToString("testfile/Sentencesort.txt"));
		TextComponent expected = separator.separate(fileReader.readToString("testfile/ExpectedSentenceSort.txt"));

		new SentenceSort().sort(actual);
		assertEquals(actual, expected);
	}
}