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
 * Class for separating text by lexical units. Implementation of the {@code ITextSeparatorChain} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ITextSeparatorChain
 * @see IdentSeparator
 * @see SentenceSeparator
 * @see SymbolOrderSeparator
 * @see SymbolSeparator
 * @see TextComponent
 * @since 12.0
 */
public class LexicalUnitSeparator implements ITextSeparatorChain {
	/**
	 * Expression for splitting text by lexical units.
	 */
	public static final String LEXICAL_UNIT_REG_EX = " +";

	/**
	 * Next {@code ITextSeparatorChain} of chain of responsibility pattern.
	 */
	private ITextSeparatorChain nextSeparator = new SymbolOrderSeparator();

	/**
	 * Separate {@code String} to lexical units as {@code TextComponent} elements.
	 * <p>
	 *
	 * @param text is {@code String} for separating.
	 * @return separated {@code TextComponent}.
	 */
	@Override
	public TextComponent separate(String text) {
		TextComponent textComponent = new TextUnitComposite();
		String[] symbolOrderGroup = text.split(LEXICAL_UNIT_REG_EX);

		for(String s : symbolOrderGroup) {
			textComponent.add(nextSeparator.separate(s));
		}

		return textComponent;
	}
}