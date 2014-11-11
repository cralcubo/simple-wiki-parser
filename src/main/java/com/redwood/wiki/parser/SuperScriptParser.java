package com.redwood.wiki.parser;

import com.redwood.wiki.utilities.ParseUtility;

public class SuperScriptParser implements Parseable {
	private static final String REG_EXPR = "\\^.+?\\^";

	/**
	 * replace		^superscript^
	 * with			{SUP()}superscript{SUP}
	 */
	public String parseToTiki(String toParse) {
		return ParseUtility.replacer("{SUP()}%s{SUP}", "\\^", toParse);
	}

	public String getRegExpr() {
		return REG_EXPR;
	}

}
