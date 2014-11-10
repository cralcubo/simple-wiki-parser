package com.redwood.wiki.parser;

import com.redwood.wiki.utilities.ParseUtility;

public class StrikeParser implements Parseable {

	private static final String REG_EXPR = "~{2}.+?~{2}";

	/**
	 * replace		~~strike~~
	 * with			--strike--
	 */
	public String parseToTiki(String toParse) {
		return ParseUtility.replacer("--%s--", "~{2}", toParse);
	}

	public String getRegExpr() {
		return REG_EXPR;
	}

}
