package com.redwood.wiki.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlParserTest {

	@Test
	public void testTikiConversion(){
		HtmlParser parser = new HtmlParser();

		String toParse = "{{{\n"
				+ "#!html \n"
				+ "<h1> Hola Mundo! </h1>\n"
				+ "}}}";
		String expected = "{HTML()}\n"
				+ "<h1> Hola Mundo! </h1>\n"
				+ "{HTML}";

		assertEquals(expected, parser.parseToTiki(toParse));

		String toParse2 = "{{{\n"
				+ "	#!html \n"
				+ "<h1> Hola Mundo! </h1>\n"
				+ "}}}";
		String expected2 = "{HTML()}\n"
				+ "	<h1> Hola Mundo! </h1>\n"
				+ "{HTML}";

		assertEquals(expected2, parser.parseToTiki(toParse2));

		String toParse3 = "{{{#!html<h1> Hola Mundo! </h1>}}}";
		String expected3 = "{HTML()}<h1> Hola Mundo! </h1>{HTML}";

		assertEquals(expected3, parser.parseToTiki(toParse3));

	}

}
