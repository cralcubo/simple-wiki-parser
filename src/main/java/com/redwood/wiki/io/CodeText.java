package com.redwood.wiki.io;

public class CodeText extends WikiText {

	public CodeText(String text) {
		super(text);
	}

	@Override
	public String getText() {
		return text;
	}

}
