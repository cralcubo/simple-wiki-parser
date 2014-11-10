package com.redwood.wiki.exec;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.redwood.wiki.io.FileManager;
import com.redwood.wiki.utilities.FileUtility;

public class ParseManagerTest {

	private static final String WIKI_FILE_PATH = "./src/test/resources/OldWikiFile";
	private static final String TIKI_WIKI_FILE_PATH = "./src/test/resources/TikiWikiFile";
	private ParseManager parseManager;
	private FileManager fileManager;

	@Before
	public void setUp(){
		fileManager = new FileManager(Paths.get(WIKI_FILE_PATH));
		parseManager = new ParseManager(fileManager);
	}

	@Test
	public void testParser() throws IOException{
		String parsedFileText = parseManager.parse();
		String expectedFileText = FileUtility.getFileAsText(TIKI_WIKI_FILE_PATH);

		assertEquals(expectedFileText, parsedFileText);
	}

}
