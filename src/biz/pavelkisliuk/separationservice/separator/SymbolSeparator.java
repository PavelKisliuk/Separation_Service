package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.SymbolLeaf;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

public class SymbolSeparator implements ITextSeparatorChain {
	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();
		for(Character ch : text.toCharArray()) {
			textComponent.add(new SymbolLeaf(ch));
		}
		return textComponent;
	}
}
