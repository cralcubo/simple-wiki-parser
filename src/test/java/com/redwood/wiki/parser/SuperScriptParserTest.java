package com.redwood.wiki.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SuperScriptParserTest {

	@Test
	public void testParseToTiki(){
		SuperScriptParser parser = new SuperScriptParser();

		String toParse = "^ telnet 10.31.2.175 ^";
		String parsed = parser.parseToTiki(toParse);
		String expected = "{SUP()} telnet 10.31.2.175 {SUP}";

		assertEquals(expected, parsed);

		String toParse2 = "^\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\n^";
		String parsed2 = parser.parseToTiki(toParse2);
		String expected2 = "{SUP()}\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\n{SUP}";

		assertEquals(expected2, parsed2);

		String toParse3 = "^\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\nsudo su\nexit\n^";
		String parsed3 = parser.parseToTiki(toParse3);
		String expected3 = "{SUP()}\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\nsudo su\nexit\n{SUP}";

		assertEquals(expected3, parsed3);

	}

}
