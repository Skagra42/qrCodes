package main.java_package;

import java.io.*;
import java.util.Scanner;

public class Logger {
	private Logger () {
	}

	static File logFile;
	static File logErrorFile;

	static FileWriter logWriter;
	static FileWriter logErrorWriter;

	public static void load () throws IOException {
		File logCount = new File ( "src/main/resources/LogCount" );

		Scanner scanner = new Scanner ( logCount );

		String logFileString = "src/main/logs/";
		String logErrorFileString = "src/main/logs/";

		int scannerInt = scanner.nextInt ();

		logFileString += Integer.toString ( scannerInt );
		logErrorFileString += Integer.toString ( scannerInt );

		logFileString += "/log.txt";
		logErrorFileString += "/log_error.txt";

		logFile = new File ( logFileString );
		logErrorFile = new File ( logErrorFileString );

		scanner.close ();

		logWriter = new FileWriter ( logFile );
		logErrorWriter = new FileWriter ( logErrorFile );

		try ( Writer writer = new FileWriter ( logCount ) ) {
			writer.write ( Integer.toString ( scannerInt ) );
		}
	}

	static void log ( String string ) throws IOException {
		logWriter.write ( string );
		logError ( string );
	}

	static void logError ( String string ) throws IOException {
		logErrorWriter.write ( string );
	}

	public static void logAndPrint ( String s ) throws IOException {
		log ( s );
		System.out.print ( s );
	}
}
