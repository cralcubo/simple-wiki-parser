package com.redwood.wiki.parser;


public class SimpleCodeParser implements Parseable {
	private static final String REG_EXPR = "`.+`";

	/**
	 * replace		`code`
	 * with 		{CODE()}code{CODE}
	 */
	@Override
	public String parseToTiki(String toParse) {
		String[] splitText = toParse.split("`");
		String parsed = "";
		for(int i = 0 ; i < splitText.length ; i++){
			parsed += splitText[i];
			if(i % 2 != 0){
				parsed += "{CODE}";
			}else if(i != splitText.length - 1){
				parsed += "{CODE()}";
			}
		}

		return parsed;
	}

	@Override
	public String getRegExpr() {
		return REG_EXPR;
	}

}
