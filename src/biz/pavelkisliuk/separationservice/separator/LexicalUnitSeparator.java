package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

public class LexicalUnitSeparator implements ITextSeparatorChain {
	private ITextSeparatorChain nextSeparator = new SymbolOrderSeparator();

	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();
		String[] symbolOrderGroup = text.split(" +");

		for(String s : symbolOrderGroup) {
			textComponent.add(nextSeparator.separate(s));
		}

		return textComponent;
	}
}
