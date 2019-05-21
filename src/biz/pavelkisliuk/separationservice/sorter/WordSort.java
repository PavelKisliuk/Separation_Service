package biz.pavelkisliuk.separationservice.sorter;

import biz.pavelkisliuk.separationservice.model.SymbolLeaf;
import biz.pavelkisliuk.separationservice.model.TextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

import java.util.Comparator;

public class WordSort {
	public void sort(TextComponent textComponent) {
		for (TextComponent ident : ((TextUnitComposite) textComponent).getTextBox()) {
			for (TextComponent sentence : ((TextUnitComposite) ident).getTextBox()) {
				for (TextComponent lexicalUnit : ((TextUnitComposite) sentence).getTextBox()) {
					for(TextComponent symbolOrder : ((TextUnitComposite) lexicalUnit).getTextBox()) {
						//delete all punctuation marks
						((TextUnitComposite) symbolOrder).getTextBox().removeIf(
								o -> !Character.isLetterOrDigit(((SymbolLeaf)o).getSymbol()));
					}
					//clean empty TextComponent
					((TextUnitComposite) lexicalUnit).getTextBox().removeIf(o -> o.toString().isEmpty());
				}
				//sort
				((TextUnitComposite) sentence).getTextBox().sort((Comparator.
						comparingInt(o -> ((TextUnitComposite)((TextUnitComposite) o).getTextBox().get(0)).
								getTextBox().size())));
			}
		}
	}
}