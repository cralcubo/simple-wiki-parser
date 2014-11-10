package com.redwood.wiki.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StrikeParserTest {

	@Test
	public void testParseToTiki(){
		StrikeParser parser = new StrikeParser();

		String toParse = "~~ telnet 10.31.2.175 ~~";
		String parsed = parser.parseToTiki(toParse);
		String expected = "-- telnet 10.31.2.175 --";

		assertEquals(expected, parsed);

		String toParse2 = "~~ abcdef \n xyz \n~~";
		String parsed2 = parser.parseToTiki(toParse2);
		String expected2 = "-- abcdef \n xyz \n--";

		assertEquals(expected2, parsed2);

	}

}
