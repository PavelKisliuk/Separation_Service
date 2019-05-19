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

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for separating text by symbols order. Implementation of the {@code ITextSeparatorChain} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ITextSeparatorChain
 * @see IdentSeparator
 * @see SentenceSeparator
 * @see LexicalUnitSeparator
 * @see SymbolSeparator
 * @see ITextComponent
 * @since 12.0
 */
public class SymbolOrderSeparator implements ITextSeparatorChain {
	/**
	 * Expression for splitting text by symbols order.
	 */
	public static final String SYMBOL_ORDER_REG_EX = "\\p{Alnum}+|((\\.{3})|(!\\.\\.)|(\\?\\.\\.)|!|\\?|\\.)";

	/**
	 * Next {@code ITextSeparatorChain} of chain of responsibility pattern.
	 */
	private ITextSeparatorChain nextSeparator = new SymbolSeparator();

	/**
	 * Separate {@code String} to symbols order as {@code ITextComponent} elements.
	 * <p>
	 *
	 * @param text is {@code String} for separating.
	 * @return separated {@code ITextComponent}.
	 */
	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();

		Pattern pattern = Pattern.compile(SYMBOL_ORDER_REG_EX);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			textComponent.add(nextSeparator.separate(matcher.group()));
		}

		return textComponent;
	}
}