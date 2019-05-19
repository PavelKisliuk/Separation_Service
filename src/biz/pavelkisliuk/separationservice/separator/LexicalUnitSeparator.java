package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

public class LexicalUnitSeparator implements ITextSeparatorChain {
	private ITextSeparatorChain nextSeparator = new SymbolOrderSeparator();

	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();
		String[] word = text.split("(!(\\.*)|\\?(\\.*)|\\.+) *");
		String[] punctuationSeparatedText = text.split("\\p{Alnum}+");

		for (String s : word) {
			if(!(s.isEmpty())) {
				textComponent.add(nextSeparator.separate(s));
			}
		}

		for (String s : punctuationSeparatedText) {
			if (!(s.isEmpty())) {
				textComponent.add(nextSeparator.separate(s));
			}
		}

		return textComponent;
	}
}
