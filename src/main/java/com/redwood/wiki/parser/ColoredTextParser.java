package com.redwood.wiki.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColoredTextParser implements Parseable{

	private static final String COLORED_TEXT_REG_EXPR = "\\[{2}(span\\().+?\\]{2}";

	/**
	 * replace		[[span(style=color: #FF0000, a red text )]]
	 * with			~~#FF0000: a red text~~
	 */
	public String parseToTiki(String toParse) {
		Matcher matcherCode  = Pattern.compile("[#][0-9|aA-fF]{6}").matcher(toParse);

		String colorCode = "";
		if(matcherCode.find()){
			colorCode = matcherCode.group();
		}

		Matcher matcherText = Pattern.compile(",[^)]+").matcher(toParse);
		String colorText = "";
		if(matcherText.find()){
			colorText = matcherText.group();
			colorText = colorText.replaceFirst(",", "");
		}

		return String.format("~~%s:%s~~", colorCode, colorText);
	}

	public String getRegExpr() {
		return COLORED_TEXT_REG_EXPR;
	}

}
