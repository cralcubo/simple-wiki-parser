package com.redwood.wiki.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.redwood.wiki.utilities.StringUtility;

public class FileManager {

    private final Path inputPath;
    private final Path outputPath;

    public FileManager(Path inputPath){
        this.inputPath = inputPath;

        String parent = ".";
        if(inputPath.getParent() != null){
        	parent = inputPath.getParent().toString();
        }

        this.outputPath = Paths.get(String.format("%s/%s.tiki", parent, inputPath.getFileName()));
    }

    public List<WikiText> getWikiTextList() throws IOException{
        List<WikiText> wikiTextList = new ArrayList<>();
        List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);

        String text = "";
        //Reg exp that find either {{{ or `
//        Pattern pattern = Pattern.compile(".*(\\{{3}|`).*");
        Pattern pattern = Pattern.compile(".*(\\{{3}).*");
        Matcher matcher;

        for(int i = 0; i < lines.size() ; i++){
            String line = lines.get(i).replaceAll("\\r", "");
            matcher = pattern.matcher(line);
            if(matcher.find()){
                //Code found, create a new plainText object with the info collected.
                if(!text.isEmpty()){
                	wikiTextList.add(new PlainText(StringUtility.removeLastCharacter(text)));
                    text = "";
                }
                //Generate a new codeText object with all the code info related
                i = generateCodeText(lines, i, wikiTextList);
            }else{
                text += line + "\n";
            }
        }

        if(!text.isEmpty()){
            wikiTextList.add(new PlainText(StringUtility.removeLastCharacter(text)));
        }


        return wikiTextList;
    }

    private int generateCodeText(List<String> lines, int index, List<WikiText> wikiTexts) {
        String text = "";

        //Find correct token to close the code text
        String regExpClose = "\\}{3}";
        String regExpOneLine = "\\{{3}.+\\}{3}";

//        if(ParseUtility.tildeFinder(lines.get(index))){
//        	regExpClose = "`";
//        	regExpOneLine = "`.+`";
//        }

        text = lines.get(index) + "\n";

        //Check if the code starts and ends in the same line
        Matcher oneLinerMatch = Pattern.compile(regExpOneLine).matcher(text);

        //Continue looping till find the token of end of code
        if(!oneLinerMatch.find()){
	        Pattern pattern = Pattern.compile(regExpClose);
	        Matcher matcher;
	        for(int i = index + 1; i < lines.size(); i++){
	            String line = lines.get(i);
	            text += line + "\n";
	            matcher = pattern.matcher(line);
	            if(matcher.find()){
	                //update index
	                index = i;
	                break;
	            }
	        }
        }

        wikiTexts.add(new CodeText(StringUtility.removeLastCharacter(text)));
    	return index;
    }


	public void write(String parsedText) throws IOException {
		Files.write(outputPath, parsedText.getBytes());
	}

	public String getOutputPath(){
		return outputPath.toString();
	}

}
