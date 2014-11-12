package com.redwood.wiki.exec;

import java.io.IOException;
import java.nio.file.Paths;

import com.redwood.wiki.io.FileManager;

public class Main {

	/**
	 * Arguments that can be set to
	 * run the program can be set here.
	 *
	 * These arguments are:
	 * args[0]: File to be parsed
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("Please enter the file path to be parsed.");
			System.exit(1);
		}
		String filePath = args[0];

		Main main = new Main();
		main.run(filePath);
	}

	private void run(String filePath) {
		FileManager fileManager = new FileManager(Paths.get(filePath));

		ParseManager parseManager = new ParseManager(fileManager);
		String parsedFileText ="";

		try {
			parsedFileText = parseManager.parse();
		} catch (IOException e) {
			System.err.println(String.format("The file: %s does not exists", filePath));
			e.printStackTrace();
			System.exit(1);
		}

		try {
			fileManager.write(parsedFileText);
			System.out.println("Done!");
			System.out.println(String.format("The parsed file is in: %s", fileManager.getOutputPath()));
		} catch (IOException e) {
			System.err.println(String.format("The file to be parsed could not be generated."));
			e.printStackTrace();
		}
	}

}
