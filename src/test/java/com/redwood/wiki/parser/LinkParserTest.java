package com.redwood.wiki.parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkParserTest {

	@Test
	public void testParseToTiki(){
		LinkParser parser = new LinkParser();
		String toParse = "[[wiki:/Dev/BuildSystems/linux-s390|v390lx31]]";
		String parsedText = parser.parseToTiki(toParse);
		String expectedText = "[v390lx31|linux-s390]";

		assertEquals(expectedText, parsedText);

		String toParse2 = "[[PageOutline(1-100,Page Index,Inline)]]";
		String parsedText2 = parser.parseToTiki(toParse2);
		String expectedText2 = "[[PageOutline(1-100,Page Index,Inline)]]";

		assertEquals(expectedText2, parsedText2);

		String toParse3 = "[[../../JCE/ShowEventsInDiagram|JCE/ShowEventsInDiagram]]";
		String parsedText3 = parser.parseToTiki(toParse3);
		String expectedText3 = "[JCE/ShowEventsInDiagram|ShowEventsInDiagram]";

		assertEquals(expectedText3, parsedText3);
		
		//[[SpecifyEventsForCalls|JobChainEngine/SpecifyEventsForCalls]]
		
		String toParse4 = "[[SpecifyEventsForCalls|JobChainEngine/SpecifyEventsForCalls]]";
		String parsedText4 = parser.parseToTiki(toParse4);
		String expectedText4 = "[JobChainEngine/SpecifyEventsForCalls|SpecifyEventsForCalls]";

		assertEquals(expectedText4, parsedText4);
	


	}

}
