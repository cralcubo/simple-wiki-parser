package com.redwood.wiki.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.redwood.wiki.utilities.FileUtility;
import com.redwood.wiki.utilities.StringUtility;

public class FileManagerTest {

	private static final String TEST_FILE_PATH = "./src/test/resources/FileManagerTestFile";

	private FileManager fileManager;

	@Before
	public void setUp(){
		fileManager = new FileManager(Paths.get(TEST_FILE_PATH));
	}

	@Test
	public void testGetWikiTextList() throws IOException{

		List<WikiText> wikiTextList = fileManager.getWikiTextList();

		assertNotNull(wikiTextList);
		assertEquals(7, wikiTextList.size());

		int codeCounter = 0;
		int plainTextCounter = 0;
		for(WikiText text : wikiTextList){

			if(text instanceof CodeText){
				System.out.println(">>>"+text.getText()+"<<<");
				codeCounter++;
			}else if(text instanceof PlainText){
				plainTextCounter++;
			}
		}

		assertEquals(3,codeCounter);
		assertEquals(4, plainTextCounter);
	}

	@Test
	public void testIfFileSplittedEqualsOriginal() throws IOException{
		String originalFile = FileUtility.getFileAsText(TEST_FILE_PATH);
		String splittedFileText = "";
		for(WikiText wikiText : fileManager.getWikiTextList()){
			splittedFileText += wikiText.getText() + "\n";
		}

		assertEquals(originalFile, StringUtility.removeLastCharacter(splittedFileText));
	}

}
