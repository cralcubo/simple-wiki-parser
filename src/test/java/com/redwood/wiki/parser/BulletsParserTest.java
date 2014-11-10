package com.redwood.wiki.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class BulletsParserTest {

	@Test
	public void testTikiConversion(){
		BulletsParser parser = new BulletsParser();

		String inputText =
				  " * UNO\n"
				+ " * DOS\n"
				+ "  * DOS-UNO\n"
				+ "  * DOS-DOS\n"
				+ "   *EXTRA\n"
				+ " *TRES";

		String expectedText =
				  "* UNO\n"
				+ "* DOS\n"
				+ "** DOS-UNO\n"
				+ "** DOS-DOS\n"
				+ "***EXTRA\n"
				+ "*TRES";

		assertEquals(expectedText, parser.parseToTiki(inputText));

		String inputText2 =
				  "* UNO\n"
				+ "* DOS\n"
				+ " * DOS-UNO\n"
				+ " * DOS-DOS\n"
				+ "  *EXTRA\n"
				+ "*TRES";

		String expectedText2 =
				  "* UNO\n"
				+ "* DOS\n"
				+ "** DOS-UNO\n"
				+ "** DOS-DOS\n"
				+ "***EXTRA\n"
				+ "*TRES";

		assertEquals(expectedText2, parser.parseToTiki(inputText2));

	}

}
