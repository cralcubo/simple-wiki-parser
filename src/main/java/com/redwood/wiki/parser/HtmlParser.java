package com.redwood.wiki.parser;

public class HtmlParser implements Parseable {
	private static final String HTML_IDENTIFIER = "#!html\\s*\\n*";

	@Override
	public String parseToTiki(String toParse) {
		String parsed = toParse.replaceAll("\\{{3}", "{HTML()}").replaceAll("\\}{3}","{HTML}");
		return parsed.replaceFirst(HTML_IDENTIFIER, "");
	}

	@Override
	public String getRegExpr() {
		throw new UnsupportedOperationException();
	}

}
