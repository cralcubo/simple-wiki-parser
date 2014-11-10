package com.redwood.wiki.parser;

import com.redwood.wiki.utilities.ParseUtility;

public class SubScriptParser implements Parseable {

	private static final String SUB_SCRIPT_REG_EX = ",{2}(.|\n)+?,{2}";

	/**
	 * replace		,,subscript,,
	 * with			{SUB()}subscript{SUB}
	 */
	public String parseToTiki(String toParse) {
		return ParseUtility.replacer("{SUB()}%s{SUB}", ",{2}", toParse);
	}

	public String getRegExpr() {
		return SUB_SCRIPT_REG_EX;
	}

}
