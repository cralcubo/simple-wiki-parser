package com.redwood.wiki.parser;

public class BreakLineParser implements Parseable {


	private static final String REG_EXPR_BR = "\\[{2}BR\\]{2}";

	/**
	 * Replace: [[BR]]
	 * for    :  \n
	 */
	@Override
	public String parseToTiki(String toParse) {
		return toParse.replaceAll(REG_EXPR_BR, "\n");
	}

	@Override
	public String getRegExpr() {
		return REG_EXPR_BR;
	}

}
