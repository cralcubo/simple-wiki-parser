package com.redwood.wiki.parser;

public class TableParser implements Parseable {

	private static final String REG_EXPR_TABLE = "(\\|{2}.*\n){1,}";
	private static final String REG_EXPR_PIPES = "\\|\\|";

	/**
	 * Replace 	||xxx||xxx||xxx||
	 * 		   	||xxx||xxx||xxx||
	 *
	 * for:    	||xxx|xxx|xxx
	 * 			  xxx|xxx|xxx||
	 *
	 */
	public String parseToTiki(String toParse) {
		//replace all double pipes but the first and last
		String parsed = toParse.replaceAll(REG_EXPR_PIPES, "|");
		//add || to the beginning and end
		return String.format("|%s|", parsed.trim());
	}

	public String getRegExpr() {
		return REG_EXPR_TABLE;
	}

}
