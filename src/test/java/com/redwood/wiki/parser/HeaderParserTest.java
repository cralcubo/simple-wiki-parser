package com.redwood.wiki.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class HeaderParserTest {

	@Test
	public void testParseToTiki(){
		HeaderParser parser = new HeaderParser();
		String oldWikiText = "=== Test ===";
		String expectedText = "!!! Test ";
		assertEquals(expectedText, parser.parseToTiki(oldWikiText));

		String oldWikiText2 = "=== Test";
		String expectedText2 = "!!! Test";
		assertEquals(expectedText2, parser.parseToTiki(oldWikiText2));

		String oldWikiText3 = "\n======= Test =======\n ";
		String expectedText3 = "\n!!!!!!! Test \n ";
		assertEquals(expectedText3, parser.parseToTiki(oldWikiText3));

		String oldWikiText4 = "======= Test ======";
		String expectedText4 = "!!!!!!! Test ";
		assertNotEquals(expectedText4, parser.parseToTiki(oldWikiText4));

	}

}
