package com.redwood.wiki.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageParserTest {

	@Test
	public void testTikiConversor(){
		ImageParser parser = new ImageParser();

		String toParse = "[[Image(New Java App.png)]]";
		String parsedText = parser.parseToTiki(toParse);
		String expectedText = "{img type=\"attId\" attId=\"8\"}";

		assertEquals(expectedText, parsedText);
	}

}
