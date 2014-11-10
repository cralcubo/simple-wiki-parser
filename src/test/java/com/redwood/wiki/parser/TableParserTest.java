package com.redwood.wiki.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TableParserTest {

	@Test
	public void testParseToTiki(){
		TableParser parser = new TableParser();

		String oldWikiText = "||xxx||xxx||\n||yyy||yyy||";
		String expectedText = "||xxx|xxx\nyyy|yyy||";
		assertEquals(expectedText, parser.parseToTiki(oldWikiText));

		String oldWikiText2 = "||=xxx=||=xxx=||\n||yyy||yyy||";
		String expectedText2 = "||=xxx=|=xxx=\nyyy|yyy||";
		assertEquals(expectedText2, parser.parseToTiki(oldWikiText2));


	}

}
