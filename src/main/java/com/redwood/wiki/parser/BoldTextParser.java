package com.redwood.wiki.parser;

import com.redwood.wiki.utilities.ParseUtility;

public class BoldTextParser implements Parseable {

	private static final String REG_EXPR = "'{3}.+?'{3}";

	/**
	 * replace	'''bold'''
	 * with		__bold__
	 */
	public String parseToTiki(String toParse) {
		return ParseUtility.replacer("__%s__", "'{3}", toParse);
	}

	public String getRegExpr() {
		return REG_EXPR;
	}

}
