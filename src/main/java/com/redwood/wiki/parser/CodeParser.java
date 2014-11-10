package com.redwood.wiki.parser;

import com.redwood.wiki.utilities.ParseUtility;

public class CodeParser implements Parseable {
	/**
	 * replace 		{{{ telnet 10.31.2.175}}}
	 * with 	 	{CODE()} telnet 10.31.2.175 {CODE}
	 *
	 * OR
	 *
	 * replace 		` telnet 10.31.2.175 `
	 * with 	 	{CODE()} telnet 10.31.2.175 {CODE}
	 */
	public String parseToTiki(String toParse) {
		if(ParseUtility.tildeFinder(toParse)){
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
        } else{
        	return toParse.replaceAll("\\{{3}", "{CODE()}").replaceAll("\\}{3}", "{CODE}");
        }
  	}

	public String getRegExpr() {
		throw new UnsupportedOperationException();
	}
}
