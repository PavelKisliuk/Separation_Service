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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class for separating text by symbols. Implementation of the {@code TextSeparatorChain} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see TextSeparatorChain
 * @see IdentSeparator
 * @see SentenceSeparator
 * @see LexicalUnitSeparator
 * @see SymbolOrderSeparator
 * @see TextComponent
 * @since 12.0
 */
public class SymbolSeparator implements TextSeparatorChain {
	private static final Logger LOGGER = LogManager.getLogger();

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

		if((text == null) ||
				(text.isEmpty()) ||
				(text.isBlank())) {
			LOGGER.log(Level.ERROR, "Problem with text in IdentSeparator. text -> " + text);
			return textComponent;
		}

		for (Character ch : text.toCharArray()) {
			textComponent.add(new SymbolLeaf(ch));
		}
		return textComponent;
	}
}