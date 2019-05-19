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

/**
 * Class for separating text by idents. Implementation of the {@code ITextSeparatorChain} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ITextSeparatorChain
 * @see SentenceSeparator
 * @see LexicalUnitSeparator
 * @see SymbolOrderSeparator
 * @see SymbolSeparator
 * @see ITextComponent
 * @since 12.0
 */
public class IdentSeparator implements ITextSeparatorChain {
	/**
	 * Expression for splitting text by idents.
	 */
	public static final String IDENT_REG_EX = "\t|\n\t|\n| {4}|\n( {4})";

	/**
	 * Next {@code ITextSeparatorChain} of chain of responsibility pattern.
	 */
	private ITextSeparatorChain nextSeparator = new SentenceSeparator();

	/**
	 * Separate {@code String} to idents as {@code ITextComponent} elements.
	 * <p>
	 *
	 * @param text is {@code String} for separating.
	 * @return separated {@code ITextComponent}.
	 */
	@Override
	public ITextComponent separate(String text) {
		ITextComponent textComponent = new TextUnitComposite();

		String[] separetedText = text.split(IDENT_REG_EX);
		for (String s : separetedText) {
			if (!(s.isEmpty())) {
				textComponent.add(nextSeparator.separate(s));
			}
		}

		return textComponent;
	}
}