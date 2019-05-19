package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

public class SentenceSeparator implements ITextSeparatorChain {
	private ITextSeparatorChain nextSeparator = new LexicalUnitSeparator();

	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();
		String[] wordSeparetedText = text.split("\\. +");
		for (String s : wordSeparetedText) {
			textComponent.add(nextSeparator.separate(s));
		}
		return textComponent;
	}
}
