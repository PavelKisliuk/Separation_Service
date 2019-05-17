package biz.pavelkisliuk.separationservice.model;

import java.util.ArrayList;

public class TextUnitComponent implements ITextComponent {
	private ArrayList<ITextComponent> textBox;

	public TextUnitComponent() {
		this.textBox = new ArrayList<>();
	}

	@Override
	public boolean add(ITextComponent textComponent) {
		return textBox.add(textComponent);
	}
}
