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
 * Leaf element of composition pattern. Implementation of the {@code ITextComponent} interface.
 * <p>
 *
 * @author Kisliuk Pavel Sergeevich
 * @see ITextComponent
 * @see TextUnitComposite
 * @since 12.0
 */
public class SymbolLeaf implements ITextComponent {
	/**
	 * Provide pure symbol of text.
	 */
	private Character symbol;

	public SymbolLeaf(Character symbol) {
		this.symbol = symbol;
	}

	/**
	 * Return {@code symbol}.
	 * <p>
	 *
	 * @return {@code symbol}.
	 */
	public Character getSymbol() {
		return symbol;
	}

	/**
	 * Replace value of {@code symbol}.
	 * <p>
	 *
	 * @param symbol is value replace {@code symbol}.
	 */
	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}

	/**
	 * Don't supported by this class.
	 * <p>
	 *
	 * @param textComponent added to {@code textBox} of {@code TextUnitComposite}.
	 * @return nothing.
	 * @throws UnsupportedOperationException anyway.
	 */
	@Override
	public boolean add(ITextComponent textComponent) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SymbolLeaf symbolLeaf1 = (SymbolLeaf) o;

		return symbol.equals(symbolLeaf1.symbol);

	}

	@Override
	public int hashCode() {
		return symbol.hashCode();
	}

	@Override
	public String toString() {
		return symbol.toString();
	}
}