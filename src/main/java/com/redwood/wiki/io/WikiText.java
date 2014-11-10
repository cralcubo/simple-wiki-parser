package com.redwood.wiki.io;

public abstract class WikiText {

	protected final String text;

	public WikiText(String text) {
		this.text = text;
	}

	public abstract String getText();

}
