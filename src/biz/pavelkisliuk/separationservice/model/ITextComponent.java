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

package biz.pavelkisliuk.separationservice.model;

/**
 * The {@code ITextComponent} interface serve for realization of
 * composition pattern.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see SymbolLeaf
 * @see TextUnitComposite
 * @since 12.0
 */
public interface ITextComponent {
	/**
	 * Add {@code ITextComponent} element to {@code textBox} of {@code TextUnitComposite}.
	 * <p>
	 *
	 * @param textComponent added to {@code textBox} of {@code TextUnitComposite}.
	 * @return {@code true}, if appending successful, else {@code false}.
	 */
	boolean add(ITextComponent textComponent);
}