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

/**
 * Class for separating text by idents. Implementation of the {@code TextSeparatorChain} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see TextSeparatorChain
 * @see SentenceSeparator
 * @see LexicalUnitSeparator
 * @see SymbolOrderSeparator
 * @see SymbolSeparator
 * @see TextComponent
 * @since 12.0
 */
public class IdentSeparator implements TextSeparatorChain {
	/**
	 * Expression for splitting text by idents.
	 */
	public static final String IDENT_REG_EX = "\t|\n\t|\n| {4}|\n( {4})";

	/**
	 * Next {@code TextSeparatorChain} of chain of responsibility pattern.
	 */
	private TextSeparatorChain nextSeparator = new SentenceSeparator();

	/**
	 * Separate {@code String} to idents as {@code TextComponent} elements.
	 * <p>
	 *
	 * @param text is {@code String} for separating.
	 * @return separated {@code TextComponent}.
	 */
	@Override
	public TextComponent separate(String text) {
		TextComponent textComponent = new TextUnitComposite();

		String[] separetedText = text.split(IDENT_REG_EX);
		for (String s : separetedText) {
			if (!(s.isEmpty())) {
				textComponent.add(nextSeparator.separate(s));
			}
		}

		return textComponent;
	}
}