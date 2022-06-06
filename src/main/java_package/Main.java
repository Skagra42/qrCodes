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
	public static void main ( String[] args ) throws IOException {
		Logger.load ();
		Logger.log ( "main\n" );
		Logger.logAndPrint ( "Would you like to read or create QR codes?\n" );
		readOrCreateQuestion ();
	}

	public static void readOrCreateQuestion () throws IOException {
		try ( Scanner scanner = new Scanner ( System.in ) ) {
			String readOrCreate = scanner.next ().toLowerCase ();
			switch ( readOrCreate ) {
				case "create." , "create" -> {
					Logger.log ( "Create." );
					codeCreatorQuestions ();
				}
				case "read." , "read" -> {
					Logger.log ( "Read." );
					codeReaderQuestions ();
				}
				default -> {
					Logger.log ( "Please answer with \"Read.\" or \"Create.\"." );
					readOrCreateQuestion ();
				}
			}
		} catch ( Exception e ) {
			Logger.logError ( e.getMessage () + "\n" );
		}
	}
}

//Parts of this were made using the following tutorial.
//https://www.youtube.com/watch?v=MP7Yrvb8LrA
