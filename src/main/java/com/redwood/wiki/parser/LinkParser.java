package com.redwood.wiki.parser;

public class LinkParser implements Parseable {
	private static final String BRACES_REG_EXP = "\\[{2}|\\]{2}";
	private static final String REG_EXPR_LINK = "\\[{2}(?!(Image|span)\\().+?\\]{2}";


	/**
	 * replace  [[wiki:/Dev/BuildSystems/linux-s390|v390lx31]]
	 * with     [v390lx31|linux-s390]
	 *
	 * where v390lx31 is the visible name and linux-s390 the link (pagename)
	 */
	public String parseToTiki(String toParse) {
		String cleanText = toParse.replaceAll(BRACES_REG_EXP, "");

		String[] words = cleanText.split("\\|");

		if(words.length <= 1){
			//Nothing to parse
			return toParse;
		}

		int slashIndex = words[0].lastIndexOf('/');
		String link = words[0];
		if(slashIndex >= 0){
			link = link.substring(slashIndex + 1);
		}

		String name = words[1];

		return String.format("[%s|%s]",name,link);
	}

	public String getRegExpr() {
		return REG_EXPR_LINK;
	}

}
