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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static final Logger LOGGER = LogManager.getLogger();

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

		if((text == null) ||
				(text.isEmpty()) ||
					(text.isBlank())) {
			LOGGER.log(Level.ERROR, "Problem with text in IdentSeparator. text -> " + text);
			return textComponent;
		}

		String[] separetedText = text.split(IDENT_REG_EX);
		for (String s : separetedText) {
			if (!(s.isEmpty())) {
				textComponent.add(nextSeparator.separate(s));
			}
		}

		return textComponent;
	}
}