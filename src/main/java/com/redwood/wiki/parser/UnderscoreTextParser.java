package com.redwood.wiki.parser;

import com.redwood.wiki.utilities.ParseUtility;

public class UnderscoreTextParser implements Parseable {

	private static final String UNDERSCORE_REG_EXPR = "_{2}";
	private static final String REG_EXPR = "_{2}.+?_{2}";


	/**
	 * replace		__under__
	 * with			===under===
	 */
	public String parseToTiki(String toParse) {
		return ParseUtility.replacer("===%s===", UNDERSCORE_REG_EXPR, toParse);
	}

	public String getRegExpr() {
		return REG_EXPR;
	}

}
