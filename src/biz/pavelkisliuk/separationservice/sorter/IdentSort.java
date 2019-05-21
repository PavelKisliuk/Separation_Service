package biz.pavelkisliuk.separationservice.sorter;

import biz.pavelkisliuk.separationservice.model.TextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

import java.util.Comparator;

public class IdentSort {
	public void sort(TextComponent textComponent) {
		((TextUnitComposite) textComponent).getTextBox().sort((Comparator.
				comparingInt(o -> ((TextUnitComposite) o).getTextBox().size())));
	}
}