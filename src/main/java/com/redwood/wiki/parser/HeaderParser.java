package com.redwood.wiki.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.redwood.wiki.utilities.ParseUtility;

public class HeaderParser implements Parseable {
	private static final String REG_EXPR_EQUALS = "={1,}";
	private static final String REG_EXPR_HEADER = "^(\\s*={1,}).*";

	private static final String REPLACEMENT_SYMBOL = "!";

	/**
	 * replace		=*=
 	 * with 		!*
	 * replace 		==*==
	 * with 		!!*
	 */
	public String parseToTiki(String line){
		String parsedLine = line;
		Matcher matcher = Pattern.compile(REG_EXPR_EQUALS).matcher(line);
		if(matcher.find()){
			String equals = matcher.group();
			String exclamations = ParseUtility.charactersGenerator(equals.length(), REPLACEMENT_SYMBOL);
			parsedLine = line.replaceFirst(equals, exclamations);
			parsedLine = parsedLine.replaceAll(equals, "");
		}

		return parsedLine;
	}

	public String getRegExpr() {
		return REG_EXPR_HEADER;
	}

}
