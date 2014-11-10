package com.redwood.wiki.utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtility {

	public static String getFileAsText(String filePath) throws IOException {
		String text = "";
		for(String line : Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8)){
			text += line + "\n";
		}

		return StringUtility.removeLastCharacter(text);
	}

}
