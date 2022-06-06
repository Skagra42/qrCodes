package main.java_package;

import java.io.IOException;
import java.util.Scanner;

public class CodeReader {
	private CodeReader () {
	}

	public static void codeReaderMain ( String[] args ) {

	}

	public static void codeReaderQuestions () throws IOException {
		try ( Scanner scanner = new Scanner ( System.in ) ) {

		} catch ( Exception e ) {
			Logger.logError ( e.getMessage () + "\n" );
		}
	}
}
