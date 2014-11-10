package com.redwood.wiki.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CodeParserTest {
	private CodeParser parser;

	@Before
	public void setUp(){
		parser = new CodeParser();
	}

//	@Test
//	public void testParseToTikiTilde(){
//		String toParseTilde = "` brew update `";
//		String parsedTilde = parser.parseToTiki(toParseTilde);
//		String expectedTilde = "{CODE()} brew update {CODE}";
//
//		assertEquals(expectedTilde, parsedTilde);
//
//		String toParseTilde2 = "` {{{ telnet 10.31.2.175 }}} `";
//		String parsedTilde2 = parser.parseToTiki(toParseTilde2);
//		String expectedTilde2 = "{CODE()} {{{ telnet 10.31.2.175 }}} {CODE}";
//
//		assertEquals(expectedTilde2, parsedTilde2);
//
//		String toParseTilde3 = "{{{ `telnet 10.31.2.175` }}}";
//		String parsedTilde3 = parser.parseToTiki(toParseTilde3);
//		String expectedTilde3 = "{CODE()} `telnet 10.31.2.175` {CODE}";
//
//		assertEquals(expectedTilde3, parsedTilde3);
//
//		//  ` brew install gnu-sed --default-names `       [[BR]]      ` brew install gawk --default-names `
//		String toParseTilde4 = "xxx  ` brew install gnu-sed --default-names `       [[BR]]      ` brew install gawk --default-names ` xxx ";
//		String parsedTilde4 = parser.parseToTiki(toParseTilde4);
//		String expectedTilde4 = "xxx  {CODE()} brew install gnu-sed --default-names {CODE}       [[BR]]      {CODE()} brew install gawk --default-names {CODE} xxx ";
//
//		assertEquals(expectedTilde4, parsedTilde4);
//	}

	@Test
	public void testParseToTikiBraces(){
		String toParse = "  {{{ telnet 10.31.2.175 }}}  ";
		String parsed = parser.parseToTiki(toParse);
		String expected = "  {CODE()} telnet 10.31.2.175 {CODE}  ";

		assertEquals(expected, parsed);

		String toParse1 = "  {{{ telnet 10.31.2.175 }}}   {{{ telnet 10.31.2.175 }}}";
		String parsed1 = parser.parseToTiki(toParse1);
		String expected1 = "  {CODE()} telnet 10.31.2.175 {CODE}   {CODE()} telnet 10.31.2.175 {CODE}";

		assertEquals(expected1, parsed1);


		String toParse2 = "{{{\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\n}}}";
		String parsed2 = parser.parseToTiki(toParse2);
		String expected2 = "{CODE()}\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\n{CODE}";

		assertEquals(expected2, parsed2);

		String toParse3 = "{{{\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\nsudo su\nexit\n}}}";
		String parsed3 = parser.parseToTiki(toParse3);
		String expected3 = "{CODE()}\nmkdir $[DIR_WORK_FOLDER]/trunk/tomcat\nsudo su\nexit\n{CODE}";

		assertEquals(expected3, parsed3);
	}

}
