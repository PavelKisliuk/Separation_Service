package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolOrderSeparator implements ITextSeparatorChain {
	private ITextSeparatorChain nextSeparator = new SymbolSeparator();

	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();
		Pattern pattern = Pattern.compile("\\p{Alnum}+|((\\.{3})|(!\\.\\.)|(\\?\\.\\.)|!|\\?|\\.)");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			textComponent.add(nextSeparator.separate(matcher.group()));
		}
		return textComponent;
	}
}