package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

public class IdentSeparator implements ITextSeparatorChain {
	private ITextSeparatorChain nextSeparator = new SentenceSeparator();

	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();
		String[] separetedText = text.split("\t|\n\t|\n| {4}|\n( {4})");
		for (String s : separetedText) {
			if (!(s.isEmpty())) {
				textComponent.add(nextSeparator.separate(s));
			}
		}
		return textComponent;
	}
}