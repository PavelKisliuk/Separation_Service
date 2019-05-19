package biz.pavelkisliuk.separationservice.sorter;

import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

public class SentenceSort {
	public void sort(TextUnitComposite text) {
		for (int i = 0; i < text.getTextBox().size(); i++) {
			for (int j = 0; j < (text.getTextBox().size() - 1); j++) {
				TextUnitComposite ident1 = (TextUnitComposite) text.getTextBox().get(j);
				TextUnitComposite ident2 = (TextUnitComposite) text.getTextBox().get(j + 1);
				if (ident1.getTextBox().size() > ident2.getTextBox().size()) {
					TextUnitComposite temp = new TextUnitComposite();
					temp.setTextBox(ident1.getTextBox());
					ident1.setTextBox(ident2.getTextBox());
					ident2.setTextBox(temp.getTextBox());

					((TextUnitComposite) text.getTextBox().get(j)).setTextBox(ident1.getTextBox());
					((TextUnitComposite) text.getTextBox().get(j + 1)).setTextBox(ident2.getTextBox());
				}
				int isd = 0;
			}
		}
	}
}
