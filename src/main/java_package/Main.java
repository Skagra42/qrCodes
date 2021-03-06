package main.java_package;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

import static main.java_package.CodeCreator.codeCreatorQuestions;
import static main.java_package.CodeReader.codeReaderQuestions;

public class Main {
	public static Scanner scanner = new Scanner ( System.in );

	public static void main ( String[] args ) throws IOException {
		Logger.load ();
		Logger.log ( "main\n" );
		Logger.logAndPrint ( "Would you like to read or create QR codes?\n" );
		readOrCreateQuestion ();
	}

	public static void readOrCreateQuestion () throws IOException {
		try {
			String readOrCreate = scanner.next ();
			Logger.log ( readOrCreate + "\n" );
			readOrCreate = readOrCreate.toLowerCase ();
			switch ( readOrCreate ) {
				case "create." , "create" -> {
					codeCreatorQuestions ();
				}
				case "read." , "read" -> {
					codeReaderQuestions ();
				}
				default -> {
					Logger.logAndPrint ( "Please answer with \"Read.\" or \"Create.\".\n" );
					readOrCreateQuestion ();
				}
			}
		} catch ( Exception e ) {
			Logger.logError ( e.getMessage () + "\n" );
		}
	}

	public static ErrorCorrectionLevel stringToECL ( String string ) throws IOException {
		ErrorCorrectionLevel errorCorrectionLevel;

		switch ( string ) {
			case "L" -> errorCorrectionLevel = ErrorCorrectionLevel.L;
			case "M" -> errorCorrectionLevel = ErrorCorrectionLevel.M;
			case "Q" -> errorCorrectionLevel = ErrorCorrectionLevel.Q;
			case "H" -> errorCorrectionLevel = ErrorCorrectionLevel.H;
			default -> {
				errorCorrectionLevel = ErrorCorrectionLevel.H;
				try {
					Logger.logError ( "The error correction input (" + string + ") was not used properly" +
							".\n" );
				} catch ( IOException e ) {
					Logger.logError ( e.getMessage () + "\n" );
				}
			}
		}

		return ( errorCorrectionLevel );
	}
}

//Parts of this were made using the following tutorial.
//https://www.youtube.com/watch?v=MP7Yrvb8LrA
