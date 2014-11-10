package com.redwood.wiki.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberingBulletParserTest {

	@Test
	public void testTikiConversor(){
		NumberingBulletParser parser =  new NumberingBulletParser();

		String toParse = "1. One\n"
				+ " 1. Two\n"
				+ " 1. Three\n"
				+ "1. Four\n"
				+ "  1. Five";

		String parsed = parser.parseToTiki(toParse);

		String expected = "# One\n"
				+ "## Two\n"
				+ "## Three\n"
				+ "# Four\n"
				+ "### Five";

		assertEquals(expected, parsed);

		String toParse2 = "1. One: 1.\n"
				+ " 1. Two: 2.\n"
				+ " 1. Three: 3.\n"
				+ "1. Four: 4.\n"
				+ "  1. Five: 5.";

		String parsed2 = parser.parseToTiki(toParse2);

		String expected2 = "# One: 1.\n"
				+ "## Two: 2.\n"
				+ "## Three: 3.\n"
				+ "# Four: 4.\n"
				+ "### Five: 5.";

		assertEquals(expected2, parsed2);

	}

}
