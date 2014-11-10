package com.redwood.wiki.parser;

public class TableParser implements Parseable {

    private static final String REG_EXPR_TABLE = "(\\|{2}.+\n*){1,}";
    private static final String REG_EXPR_PIPES = "\\|{2}";

    /**
     * Replace 	||xxx||xxx||xxx||
     * 		   	||xxx||xxx||xxx||
     *
     * for:    	||xxx|xxx|xxx
     * 			  xxx|xxx|xxx||
     *
     */
    public String parseToTiki(String toParse) {
    	String parsed = "";
        String[] tableLines = toParse.split("\n");

        for(int i = 0; i < tableLines.length ; i++){
        	String line = tableLines[i].trim();

        	if(!line.isEmpty()){
        		line = line.replaceAll(REG_EXPR_PIPES, "|");
        		line = line.substring(0, line.length() - 1); //This will remove the last pipe

            	if(i == 0){
            		line = "|" + line;
            	}else if(i == tableLines.length - 1){
            		line = line + "|";
            	}
        	}

        	parsed += line + "\n";
        }

        return parsed;




//
//
//        //replace all double pipes but the first and last
//        String parsed = toParse.replaceAll(REG_EXPR_PIPES, "|");
//        //add || to the beginning and end
//
//
//        return String.format("|%s|", parsed.trim());
    }

    public String getRegExpr() {
        return REG_EXPR_TABLE;
    }

}
