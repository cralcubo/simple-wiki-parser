package com.redwood.wiki.exec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.redwood.wiki.io.CodeText;
import com.redwood.wiki.io.FileManager;
import com.redwood.wiki.io.PlainText;
import com.redwood.wiki.io.WikiText;
import com.redwood.wiki.parser.BoldTextParser;
import com.redwood.wiki.parser.BulletsParser;
import com.redwood.wiki.parser.CodeParser;
import com.redwood.wiki.parser.ColoredTextParser;
import com.redwood.wiki.parser.HeaderParser;
import com.redwood.wiki.parser.ImageParser;
import com.redwood.wiki.parser.LinkParser;
import com.redwood.wiki.parser.NumberingBulletParser;
import com.redwood.wiki.parser.Parseable;
import com.redwood.wiki.parser.Parser;
import com.redwood.wiki.parser.StrikeParser;
import com.redwood.wiki.parser.SubScriptParser;
import com.redwood.wiki.parser.SuperScriptParser;
import com.redwood.wiki.parser.TableParser;
import com.redwood.wiki.parser.UnderscoreTextParser;
import com.redwood.wiki.utilities.StringUtility;

public class ParseManager {

	private final FileManager fileManager;

	private final List<Parseable> parsersList;

	public ParseManager(FileManager fileManager){
		this.fileManager = fileManager;
		parsersList = getNeededParsers();
	}

	public String parse() throws IOException {
		String parsedText = "";
		Parser parser = new Parser();

		for(WikiText wikiText : fileManager.getWikiTextList()){
			if(wikiText instanceof PlainText){
				String text = wikiText.getText();
				 for(Parseable parseable : parsersList){
					 text = parser.parseText(text, parseable);
				 }
				 parsedText += text + "\n";
			}else if(wikiText instanceof CodeText){
				String codeText = new CodeParser().parseToTiki(wikiText.getText());
				parsedText += codeText + "\n";
			}
		}

		return StringUtility.removeLastCharacter(parsedText);
	}

	private List<Parseable> getNeededParsers(){
		List<Parseable> parseables = new ArrayList<Parseable>();

		//Set all the parsers to be used:
    	parseables.add(new HeaderParser());
    	parseables.add(new TableParser());
    	parseables.add(new LinkParser());
    	parseables.add(new UnderscoreTextParser());
    	parseables.add(new BoldTextParser());
    	parseables.add(new StrikeParser());
    	parseables.add(new SuperScriptParser());
    	parseables.add(new SubScriptParser());
    	parseables.add(new ColoredTextParser());
    	parseables.add(new ImageParser());
    	parseables.add(new BulletsParser());
    	parseables.add(new NumberingBulletParser());

    	return parseables;
	}
}
