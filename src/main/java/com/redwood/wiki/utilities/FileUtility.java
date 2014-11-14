package com.redwood.wiki.utilities;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileUtility {

	private static final Charset DEFAULT_CHARSET = StandardCharsets.ISO_8859_1;

	public static String getFileAsText(String filePath) throws IOException {
		String text = "";
		for(String line : readAllLines(Paths.get(filePath))){
			text += line + "\n";
		}

		return StringUtility.removeLastCharacter(text);
	}


	public static List<String> readAllLines(Path path) throws IOException{
		//ISO 8859 1 or Latin 1 charsets will be used to recognize strange characters.
		return Files.readAllLines(path, DEFAULT_CHARSET);
	}

	public static void write(String text, Path path) throws IOException{
		Files.write(path, Arrays.asList(text.split("\n")), DEFAULT_CHARSET);
	}

}
