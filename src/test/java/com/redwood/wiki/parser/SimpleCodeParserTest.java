package com.redwood.wiki.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleCodeParserTest {


	@Test
	public void testParseToTikiTilde(){
		SimpleCodeParser parser = new SimpleCodeParser();

		String toParseTilde = "` brew update `";
		String parsedTilde = parser.parseToTiki(toParseTilde);
		String expectedTilde = "{CODE()} brew update {CODE}";

		assertEquals(expectedTilde, parsedTilde);

		String toParseTilde2 = "` {{{ telnet 10.31.2.175 }}} `";
		String parsedTilde2 = parser.parseToTiki(toParseTilde2);
		String expectedTilde2 = "{CODE()} {{{ telnet 10.31.2.175 }}} {CODE}";

		assertEquals(expectedTilde2, parsedTilde2);

		String toParseTilde3 = "{{{ `telnet 10.31.2.175` }}}";
		String parsedTilde3 = parser.parseToTiki(toParseTilde3);
		String expectedTilde3 = "{{{ {CODE()}telnet 10.31.2.175{CODE} }}}";

		assertEquals(expectedTilde3, parsedTilde3);

		//  ` brew install gnu-sed --default-names `       [[BR]]      ` brew install gawk --default-names `
		String toParseTilde4 = "xxx  ` brew install gnu-sed --default-names `       [[BR]]      ` brew install gawk --default-names ` xxx ";
		String parsedTilde4 = parser.parseToTiki(toParseTilde4);
		String expectedTilde4 = "xxx  {CODE()} brew install gnu-sed --default-names {CODE}       [[BR]]      {CODE()} brew install gawk --default-names {CODE} xxx ";

		assertEquals(expectedTilde4, parsedTilde4);
	}

}
