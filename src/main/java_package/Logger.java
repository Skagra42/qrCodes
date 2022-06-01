package main.java_package;

import java.io.*;
import java.util.Scanner;

public class Logger {
	static File logFile;
	static File logErrorFile;

	static FileWriter logWriter;
	static FileWriter logErrorWriter;

	public static void load () throws IOException {
		File logCount = new File("main/resources/LogCount");

		Scanner scanner = new Scanner ( logCount );

		String logFileString = "main/logs/log/";
		String logErrorFileString = "main/logs/log_error/";

		int scannerInt = scanner.nextInt ();

		logFileString += Integer.toString ( scannerInt );
		logErrorFileString += Integer.toString ( scannerInt );

		logFile = new File ( logFileString );
		logFile = new File ( logErrorFileString );

		scanner.close ();

		try (Writer writer = new FileWriter ( logCount )) {
			writer.write ( Integer.toString ( scannerInt ) );
		}
	}

	static void log ( String string ) throws IOException {
		logWriter.write ( string );
		logError (string);
	}

	static void logError ( String string ) throws IOException {
		logErrorWriter.write ( string );
	}

	public static void logAndPrint ( String s ) throws IOException {
		log (s);
		System.out.print (s);
	}
}