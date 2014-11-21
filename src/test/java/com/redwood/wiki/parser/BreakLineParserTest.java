package com.redwood.wiki.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BreakLineParserTest {

	@Test
	public void testParseToTiki(){
		BreakLineParser parser = new BreakLineParser();

		String toParseTilde = "Line 1[[BR]]Line 2";
		String parsedTilde = parser.parseToTiki(toParseTilde);
		String expectedTilde = "Line 1\nLine 2";

		assertEquals(expectedTilde, parsedTilde);

		String toParseTilde2 = "	Line 1	[[BR]]	Line 2	";
		String parsedTilde2 = parser.parseToTiki(toParseTilde2);
		String expectedTilde2 = "	Line 1	\n	Line 2	";

		assertEquals(expectedTilde2, parsedTilde2);

		String toParseTilde3 = "	Line 1	[[BR]]	Line 2	[[BR]] Line 3[[BR]]Line 4";
		String parsedTilde3 = parser.parseToTiki(toParseTilde3);
		String expectedTilde3 = "	Line 1	\n	Line 2	\n Line 3\nLine 4";

		assertEquals(expectedTilde3, parsedTilde3);

	}

}
