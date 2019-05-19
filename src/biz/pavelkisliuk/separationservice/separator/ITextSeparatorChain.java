package biz.pavelkisliuk.separationservice.separator;

import biz.pavelkisliuk.separationservice.model.ITextComponent;

public interface ITextSeparatorChain {
	ITextComponent separate(String text);
}
