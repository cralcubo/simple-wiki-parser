package com.redwood.wiki.parser;

import java.util.regex.Pattern;

public class TableParser implements Parseable {

    private static final String REG_EXPR_TABLE = "(\\|{2}.+\n*){1,}";

    /**
     * Replace 	||xxx||xxx||xxx||
     * 		   	||xxx||xxx||xxx||
     *
     * for:    	||xxx|xxx|xxx
     * 			  xxx|xxx|xxx||
     *
     */
    public String parseToTiki(String toParse) {
    	String parsed = toParse.trim().replaceAll("\\|{2}", "|");
    	parsed = Pattern.compile("^\\||\\|$", Pattern.MULTILINE).matcher(parsed).replaceAll("");
    	
    	return String.format("||%s||", parsed);
    }

    public String getRegExpr() {
        return REG_EXPR_TABLE;
    }

}
