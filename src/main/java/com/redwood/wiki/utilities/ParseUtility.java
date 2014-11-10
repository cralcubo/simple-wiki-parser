package com.redwood.wiki.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtility {

	/**
	 * Simple method that replace surrounding characters to the template
	 * provided.
	 *
	 * @param template The template that will surround the text stripped out.
	 * @param regExpr The regular expression that will get rid of the characters surrounding the text.
	 * @param originalText
	 * @return
	 */
	public static String replacer(String template, String regExpr, String originalText){
		String parsed = originalText.replaceAll(regExpr, "");

		return String.format(template, parsed);
	}

	/**
	 * Help method to generate a character
	 * repeated as many times as required.
	 *
	 * @param length of the characters repeated.
	 * @param character to be repeated.
	 * @return
	 */
	public static String charactersGenerator(int length, String character){
		String exclamations = "";
		for(int i = 0 ; i < length ; i++){
			exclamations +=character;
		}
		return exclamations;
	}

	public static boolean tildeFinder(String text){
		Matcher tildeMatcher = Pattern.compile("`").matcher(text);
		Matcher bracketMatcher = Pattern.compile("\\{{3}").matcher(text);

		//Check if the first token was ` or {{{
		boolean tildeFound = tildeMatcher.find();
		boolean bracketFound = bracketMatcher.find();

		return (tildeFound && !bracketFound)
        		||
        		((tildeFound && bracketFound) && (tildeMatcher.start() < bracketMatcher.start()));

	}

}
