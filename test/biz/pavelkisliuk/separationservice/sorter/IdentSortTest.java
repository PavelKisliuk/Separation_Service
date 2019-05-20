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
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class IdentSortTest {

	@Test
	public void testSort() {
		List<String> file = new ArrayList<>();
		try(BufferedReader reader = Files.newBufferedReader(Paths.get("testfile/Identsort.txt"))) {
			file = reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> expectedList = new ArrayList<>();
		try(BufferedReader reader = Files.newBufferedReader(Paths.get("testfile/ExpectedIdentSort.txt"))) {
			expectedList = reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		StringBuilder stringBuilder = new StringBuilder();
		for(String s : file) {
			stringBuilder.append(s);
		}
		ITextSeparatorChain separator = new IdentSeparator();
		TextComponent textComponent = separator.separate(stringBuilder.toString());

		stringBuilder = new StringBuilder();
		for(String s : expectedList) {
			stringBuilder.append(s);
		}
		TextComponent expected = separator.separate(stringBuilder.toString());
		new IdentSort().sort((TextUnitComposite)textComponent);
		assertEquals(textComponent, expected);
	}
}