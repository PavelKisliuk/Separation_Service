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
import biz.pavelkisliuk.separationservice.model.SymbolLeaf;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

/**
 * Class for separating text by symbols. Implementation of the {@code ITextSeparatorChain} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ITextSeparatorChain
 * @see IdentSeparator
 * @see SentenceSeparator
 * @see LexicalUnitSeparator
 * @see SymbolOrderSeparator
 * @see TextComponent
 * @since 12.0
 */
public class SymbolSeparator implements ITextSeparatorChain {
	/**
	 * Separate {@code String} to symbols as {@code TextComponent} elements.
	 * <p>
	 *
	 * @param text is {@code String} for separating.
	 * @return separated {@code TextComponent}.
	 */
	@Override
	public TextComponent separate(String text) {
		TextComponent textComponent = new TextUnitComposite();
		for (Character ch : text.toCharArray()) {
			textComponent.add(new SymbolLeaf(ch));
		}
		return textComponent;
	}
}