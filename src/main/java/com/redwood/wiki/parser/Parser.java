package com.redwood.wiki.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	public String parseText(String text, Parseable parseable){
		try{
			Pattern p = Pattern.compile(parseable.getRegExpr(), Pattern.MULTILINE);
	        Matcher matcher = p.matcher(text);

	        String parsedText = text;

	        while(matcher.find()){
	        	String textFound = matcher.group();
	        	//Cleaning the text found from new lines:
	        	textFound = textFound.replaceAll("(?s)(^\n+|\n$)", "");
	        	parsedText = parsedText.replace(textFound, parseable.parseToTiki(textFound));
	        }

	        return parsedText;
		} catch (UnsupportedOperationException e){
			return text;
		}
	}

}
