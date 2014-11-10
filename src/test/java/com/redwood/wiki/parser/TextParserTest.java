package com.redwood.wiki.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextParserTest {

	@Test
	public void testParseToTiki_Bold(){
		BoldTextParser parser = new BoldTextParser();

		String toParse = "'''bold'''";
		String parsed = parser.parseToTiki(toParse);
		String expected = "__bold__";

		assertEquals(expected, parsed);

		String toParse2 = "''' another bold text\n- More 'bold' text'''";
		String parsed2 = parser.parseToTiki(toParse2);
		String expected2 = "__ another bold text\n- More 'bold' text__";

		assertEquals(expected2, parsed2);
	}

	@Test
	public void testParseToTiki_Underscore(){
		UnderscoreTextParser parser = new UnderscoreTextParser();

		String toParse = "__under__";
		String parsed = parser.parseToTiki(toParse);
		String expected = "===under===";

		assertEquals(expected, parsed);

		String toParse2 = "__ another bold text\n- More 'bold' text__";
		String parsed2 = parser.parseToTiki(toParse2);
		String expected2 = "=== another bold text\n- More 'bold' text===";

		assertEquals(expected2, parsed2);


	}

}
