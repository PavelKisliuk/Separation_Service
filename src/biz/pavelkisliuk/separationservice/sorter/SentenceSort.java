package biz.pavelkisliuk.separationservice.sorter;

import biz.pavelkisliuk.separationservice.model.TextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

import java.util.Comparator;

public class SentenceSort {
	public void sort(TextComponent textComponent) {
		for (TextComponent ident : ((TextUnitComposite)textComponent).getTextBox()) {
				((TextUnitComposite) ident).getTextBox().sort((Comparator.
						comparingInt(o -> ((TextUnitComposite) o).getTextBox().size())));
		}
	}
}