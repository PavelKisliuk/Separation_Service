/*
 * By Pavel Kisliuk, 19.05.2019
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

package biz.pavelkisliuk.separationservice.recreator;

import biz.pavelkisliuk.separationservice.model.TextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class repair {@code TextComponent} element's to {@code String}.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see TextComponent
 * @see TextUnitComposite
 * @since 12.0
 */
public class Recreator {
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Return {@code String} repaired representation of {@code TextComponent}.
	 * <p>
	 *
	 * @param textComponent is realization of composition pattern.
	 * @return {@code String} repaired representation of {@code TextComponent}.
	 */
	public String recreate(TextComponent textComponent) {
		if((textComponent == null)) {
			LOGGER.log(Level.ERROR, "text component is null!");
			return "";
		}

		StringBuilder stringBuilder = new StringBuilder();
		LOGGER.log(Level.TRACE, "Start recreate: " + textComponent);
		//------------------------------------------------------------
		for (TextComponent ident : ((TextUnitComposite) textComponent).getTextBox()) {
			stringBuilder.append("\t");
			//------------------------------------------------------------
			for (TextComponent sentence : ((TextUnitComposite) ident).getTextBox()) {
				//------------------------------------------------------------
				for (TextComponent lexicalUnit : ((TextUnitComposite) sentence).getTextBox()) {
					stringBuilder.append(lexicalUnit.toString()).append(" ");
				}
				//------------------------------------------------------------
			}
			//------------------------------------------------------------
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			stringBuilder.append("\n");
			//------------------------------------------------------------
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		//------------------------------------------------------------
		LOGGER.log(Level.DEBUG, "textComponent recreated:" + stringBuilder);
		return stringBuilder.toString();
	}
}