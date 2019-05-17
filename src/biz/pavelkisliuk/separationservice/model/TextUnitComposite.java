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

import java.util.ArrayList;

/**
 * Composite element of composition pattern. Implementation of the {@code ITextComponent} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ITextComponent
 * @see SymbolLeaf
 * @since 12.0
 */
public class TextUnitComposite implements ITextComponent {
	/**
	 * Provide {@code ArrayList} of {@code ITextComponent} for composition
	 * pattern realization.
	 */
	private ArrayList<ITextComponent> textBox;

	/**
	 * Default constructor.
	 */
	public TextUnitComposite() {
		textBox = new ArrayList<>();
	}

	/**
	 * Return {@code textBox}.
	 * <p>
	 *
	 * @return {@code textBox}.
	 */
	public ArrayList<ITextComponent> getTextBox() {
		return textBox;
	}

	/**
	 * Replace value of {@code textBox}.
	 * <p>
	 *
	 * @param textBox is value replace {@code textBox}.
	 */
	public void setTextBox(ArrayList<ITextComponent> textBox) {
		this.textBox = textBox;
	}

	/**
	 * Append {@code ITextComponent} to {@code textBox}.
	 * <p>
	 *
	 * @param textComponent added to {@code textBox} of {@code TextUnitComposite}.
	 * @return {@code true}, if appending successful, else {@code false}.
	 */
	@Override
	public boolean add(ITextComponent textComponent) {
		return textBox.add(textComponent);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		TextUnitComposite that = (TextUnitComposite) o;

		return textBox.equals(that.textBox);

	}

	@Override
	public int hashCode() {
		return textBox.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (ITextComponent box : textBox) {
			stringBuilder.append(box.toString());
		}
		return stringBuilder.toString();
	}
}