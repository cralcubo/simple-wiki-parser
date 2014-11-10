package com.redwood.wiki.io;

public class PlainText extends WikiText {

	public PlainText(String text) {
		super(text);
	}

	@Override
	public String getText() {
		return text;
	}

}
