package com.redwood.wiki.parser;

public interface Parseable {

	String parseToTiki(String toParse);
	String getRegExpr();

}
