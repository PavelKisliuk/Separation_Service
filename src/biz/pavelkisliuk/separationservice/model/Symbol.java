package biz.pavelkisliuk.separationservice.model;

public class Symbol implements ITextComponent {
	private Character symbol;

	public Symbol(Character symbol) {
		this.symbol = symbol;
	}

	@Override
	public boolean add(ITextComponent textComponent) {
		throw new UnsupportedOperationException();
	}
}
