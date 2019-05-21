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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for separating text by sentences. Implementation of the {@code TextSeparatorChain} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see TextSeparatorChain
 * @see IdentSeparator
 * @see LexicalUnitSeparator
 * @see SymbolOrderSeparator
 * @see SymbolSeparator
 * @see TextComponent
 * @since 12.0
 */
public class SentenceSeparator implements TextSeparatorChain {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Expression for splitting text by sentences.
	 */
	public static final String SENTENCE_REG_EX = "(\\p{Alnum}+( \\p{Alnum})*)+(!(\\.*)|\\?(\\.*)|\\.+)*";

	/**
	 * Next {@code TextSeparatorChain} of chain of responsibility pattern.
	 */
	private TextSeparatorChain nextSeparator = new LexicalUnitSeparator();

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

		if((text == null) ||
				(text.isEmpty()) ||
				(text.isBlank())) {
			LOGGER.log(Level.ERROR, "Problem with text in IdentSeparator. text -> " + text);
			return textComponent;
		}

		Pattern pattern = Pattern.compile(SENTENCE_REG_EX);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			textComponent.add(nextSeparator.separate(matcher.group()));
		}

		return textComponent;
	}
}