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

import biz.pavelkisliuk.separationservice.model.ITextComponent;
import biz.pavelkisliuk.separationservice.model.TextUnitComposite;

/**
 * The class repair {@code ITextComponent} element's to {@code String}.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ITextComponent
 * @see TextUnitComposite
 * @since 12.0
 */
public class Recreator {
	/**
	 * Return {@code String} repaired representation of {@code ITextComponent}.
	 * <p>
	 *
	 * @param textComponent is realization of composition pattern.
	 * @return {@code String} repaired representation of {@code ITextComponent}.
	 */
	public String recreate(ITextComponent textComponent) {
		StringBuilder stringBuilder = new StringBuilder();
		//------------------------------------------------------------
		for (ITextComponent ident : ((TextUnitComposite) textComponent).getTextBox()) {
			stringBuilder.append("\t");
			//------------------------------------------------------------
			for (ITextComponent sentence : ((TextUnitComposite) ident).getTextBox()) {
				//------------------------------------------------------------
				for (ITextComponent lexicalUnit : ((TextUnitComposite) sentence).getTextBox()) {
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
		return stringBuilder.toString();
	}
}