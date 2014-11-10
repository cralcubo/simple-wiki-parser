package com.redwood.wiki.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColoredTextParserTest {

	@Test
	public void testTikiConverter(){
		ColoredTextParser parser = new ColoredTextParser();

		String toParse = "[[span(style=color: #FF0000, a red text)]]";
		String parsedText = parser.parseToTiki(toParse);
		String expectedText = "~~#FF0000: a red text~~";

		assertEquals(expectedText, parsedText);

		String toParse2 = "[[span(style=color: #FFAA12, a red text that is long, and also has a new line\nplus a tab\t TEST)]]";
		String parsedText2 = parser.parseToTiki(toParse2);
		String expectedText2 = "~~#FFAA12: a red text that is long, and also has a new line\nplus a tab\t TEST~~";

		assertEquals(expectedText2, parsedText2);

	}

}
