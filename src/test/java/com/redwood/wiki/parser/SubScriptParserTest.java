package com.redwood.wiki.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubScriptParserTest {

	@Test
	public void testParseToTiki(){
		SubScriptParser parser = new SubScriptParser();

		String toParse = ",, telnet 10.31.2.175 ,,";
		String parsed = parser.parseToTiki(toParse);
		String expected = "{SUB()} telnet 10.31.2.175 {SUB}";

		assertEquals(expected, parsed);

		String toParse2 = ",,\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\n,,";
		String parsed2 = parser.parseToTiki(toParse2);
		String expected2 = "{SUB()}\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\n{SUB}";

		assertEquals(expected2, parsed2);

		String toParse3 = ",,\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\nsudo su\nexit\n,,";
		String parsed3 = parser.parseToTiki(toParse3);
		String expected3 = "{SUB()}\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\nsudo su\nexit\n{SUB}";

		assertEquals(expected3, parsed3);

	}



}
