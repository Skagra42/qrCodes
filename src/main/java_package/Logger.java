package main.java_package;

import java.io.*;
import java.util.Scanner;

public class Logger {
	private Logger () {
	}

	static File logFolder;

	static FileWriter logWriter;
	static FileWriter logErrorWriter;

	public static void load () throws IOException {
		File logCount = new File ( "src/main/resources/LogCount" );

		Scanner loggerScanner = new Scanner ( logCount );

		String logFileString = "src/main/logs/";
		String logErrorFileString = "src/main/logs/";

		int scannerInt = loggerScanner.nextInt ();

		logFileString += Integer.toString ( scannerInt );
		logErrorFileString += Integer.toString ( scannerInt );

		logFolder = new File ( logFileString );
		logFolder.mkdir ();

		logFileString += "/log.txt";
		logErrorFileString += "/log_error.txt";

		loggerScanner.close ();

		logWriter = new FileWriter ( logFileString );
		logErrorWriter = new FileWriter ( logErrorFileString );

		try ( Writer writer = new FileWriter ( logCount ) ) {
			writer.write ( Integer.toString ( scannerInt + 1 ) );
		}
	}

	static void log ( String string ) throws IOException {
		logWriter.write ( string );
		logWriter.flush ();
		logError ( string );
	}

	static void logError ( String string ) throws IOException {
		logErrorWriter.write ( string );
		logErrorWriter.flush ();
	}

	public static void logAndPrint ( String string ) throws IOException {
		log ( string );
		System.out.print ( string );
	}

	public static void logErrorAndPrint ( String string ) throws IOException {
		logError ( string );
		System.out.print ( string );
	}
}
