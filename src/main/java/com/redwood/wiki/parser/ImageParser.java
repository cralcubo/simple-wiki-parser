package com.redwood.wiki.parser;

public class ImageParser implements Parseable {
	private static final String REG_EXPR = "\\[{2}(Image\\().+?\\]{2}";
	private static final String HARDCODED_TEXT = "{img type=\"attId\" attId=\"8\"}";

	/**
	 * replace		[[Image(New Java App.png)]]
	 * with			{img type="attId" attId="8"}
	 */
	public String parseToTiki(String toParse) {
		return HARDCODED_TEXT;
	}

	public String getRegExpr() {
		return REG_EXPR;
	}

}
