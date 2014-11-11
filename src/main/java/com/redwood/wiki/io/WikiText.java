package com.redwood.wiki.io;

public class WikiText {

	protected final String text;
	private final WikiTextType type;

	public WikiText(String text, WikiTextType type) {
		this.text = text;
		this.type = type;
	}

	public String getText(){
		return text;
	}

	public WikiTextType getType(){
		return type;
	}
}
