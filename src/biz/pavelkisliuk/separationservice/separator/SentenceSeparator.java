/*
 * By Pavel Kisliuk, 17.05.2019
 * This is class for education and nothing rights don't reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.TextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for separating text by sentences. Implementation of the {@code ITextSeparatorChain} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ITextSeparatorChain
 * @see IdentSeparator
 * @see LexicalUnitSeparator
 * @see SymbolOrderSeparator
 * @see SymbolSeparator
 * @see TextComponent
 * @since 12.0
 */
public class SentenceSeparator implements ITextSeparatorChain {
	/**
	 * Expression for splitting text by sentences.
	 */
	public static final String SENTENCE_REG_EX = "(\\p{Alnum}+( \\p{Alnum})*)+(!(\\.*)|\\?(\\.*)|\\.+)*";

	/**
	 * Next {@code ITextSeparatorChain} of chain of responsibility pattern.
	 */
	private ITextSeparatorChain nextSeparator = new LexicalUnitSeparator();

	/**
	 * Separate {@code String} to sentences as {@code TextComponent} elements.
	 * <p>
	 *
	 * @param text is {@code String} for separating.
	 * @return separated {@code TextComponent}.
	 */
	@Override
	public TextComponent separate(String text) {
		TextComponent textComponent = new TextUnitComposite();

		Pattern pattern = Pattern.compile(SENTENCE_REG_EX);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			textComponent.add(nextSeparator.separate(matcher.group()));
		}

		return textComponent;
	}
}