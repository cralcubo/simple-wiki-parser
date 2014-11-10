package com.redwood.wiki.utilities;

public class StringUtility {

	public static String removeLastCharacter(String text){
		if(!text.isEmpty()){
			return text.substring(0, text.length() - 1);
		}
		return text;
	}

}
