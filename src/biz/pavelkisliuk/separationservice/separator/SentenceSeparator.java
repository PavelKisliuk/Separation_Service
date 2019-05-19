package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceSeparator implements ITextSeparatorChain {
	private ITextSeparatorChain nextSeparator = new LexicalUnitSeparator();

	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();
		Pattern pattern = Pattern.compile("(\\p{Alnum}+( \\p{Alnum})*)+(!(\\.*)|\\?(\\.*)|\\.+)*");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			textComponent.add(nextSeparator.separate(matcher.group()));
		}
		return textComponent;
	}
}
