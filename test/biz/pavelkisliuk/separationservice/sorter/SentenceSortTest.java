package biz.pavelkisliuk.separationservice.sorter;

import biz.pavelkisliuk.separationservice.model.TextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;
import biz.pavelkisliuk.separationservice.separator.ITextSeparatorChain;
import biz.pavelkisliuk.separationservice.separator.IdentSeparator;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceSortTest {

	@Test
	public void testSort() {
		List<String> file = new ArrayList<>();
		try(BufferedReader reader = Files.newBufferedReader(Paths.get("testfile/Sentencesort.txt"))) {
			file = reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(String s : file) {
			stringBuilder.append(s);
		}

		ITextSeparatorChain separator = new IdentSeparator();
		TextComponent textComponent = separator.separate(stringBuilder.toString());
		TextComponent ident = ((TextUnitComposite)textComponent).getTextBox().get(0);

		((TextUnitComposite)ident).getTextBox().sort((Comparator.
				comparingInt(o -> ((TextUnitComposite) o).getTextBox().size())));

		new SentenceSort().sort((TextUnitComposite) ident);

		int isd = 0;
	}
}