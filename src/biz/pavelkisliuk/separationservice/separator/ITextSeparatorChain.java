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

/**
 * The {@code ITextSeparatorChain} interface for realization chain of responsibility
 * pattern for separating {@code String} of text as ident, sentence, lexical unit and symbol order.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see IdentSeparator
 * @see SentenceSeparator
 * @see LexicalUnitSeparator
 * @see SymbolOrderSeparator
 * @see SymbolSeparator
 * @see ITextComponent
 * @since 12.0
 */
public interface ITextSeparatorChain {
	/**
	 * Separate {@code String} to {@code ITextComponent} elements.
	 * <p>
	 *
	 * @param text is {@code String} for separating.
	 * @return separated {@code ITextComponent}.
	 */
	ITextComponent separate(String text);
}