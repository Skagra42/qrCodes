package main.java_package;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.module.Configuration;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

public class CodeCreator {
	private CodeCreator () {
	}

	//args [0] is the path of the file the codes will be put in.
	//args [1] is the datatype.
	//args [2] is the error correction.
	//args [3] is the version.
	//args [4] is the width.
	//args [5] is the height.
	//args [6+] are the names, followed by the Strings to turn into codes, followed by whether or not those strings
	// are names of files to turn into codes.
	public static void codeCreatorMain ( String[] args ) throws FormatException, IOException {
		Logger.log ( "codeCreatorMain\n" );

		for ( int a = 8 ; a < args.length ; a += 3 ) {
			String[] relevantArgs = new String[ 9 ];
			relevantArgs[ 0 ] = args[ 0 ];
			relevantArgs[ 1 ] = args[ 1 ];
			relevantArgs[ 2 ] = args[ 2 ];
			relevantArgs[ 3 ] = args[ 3 ];
			relevantArgs[ 4 ] = args[ 4 ];
			relevantArgs[ 5 ] = args[ 5 ];
			relevantArgs[ 6 ] = args[ a - 2 ];
			relevantArgs[ 7 ] = args[ a - 1 ];
			relevantArgs[ 8 ] = args[ a ];
			createCode ( relevantArgs );
		}
	}

	public static void createCode ( String[] relevantArgs ) throws FormatException, IOException {
		String filePath = relevantArgs[ 1 ];
		String datatype = relevantArgs[ 2 ];
		String errorCorrection = relevantArgs[ 3 ];
		String version = relevantArgs[ 4 ];
		String name = relevantArgs[ 7 ];
		String input = relevantArgs[ 8 ];
		Boolean isFile = Boolean.valueOf ( relevantArgs[ 9 ] );
		int widthInt = Integer.parseInt ( relevantArgs[ 5 ] );
		int heightInt = Integer.parseInt ( relevantArgs[ 6 ] );

		String helperInput = input;
		BufferedImage code = createCodeHelper ( widthInt , heightInt , errorCorrection.toUpperCase () ,
				version.toLowerCase () , helperInput );

		File file = new File ( filePath + "/" + name );
	}

	public static BufferedImage createCodeHelper ( int width , int height , String errorCorrection ,
												   String versionInput , String input ) throws FormatException,
			IOException {
		BitMatrix bitMatrix = new BitMatrix ( width , height );
		ErrorCorrectionLevel errorCorrectionLevel;

		/*
		Version version;

		if (versionInput.equals ("default")) {
			version = Version.getVersionForDimensions ();
		} else {
			version = Version.getVersionForNumber(Integer.parseInt(versionInput));
		}
		 */

		errorCorrectionLevel = Main.stringToECL (errorCorrection);

		Map < EncodeHintType, Object > map = new EnumMap <> ( EncodeHintType.class );
		map.put ( EncodeHintType.ERROR_CORRECTION , errorCorrectionLevel );
		//map.put (EncodeHintType.QR_VERSION, version);

		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter ();
			bitMatrix = qrCodeWriter.encode ( input , BarcodeFormat.QR_CODE , width , height , map );
		} catch ( IllegalArgumentException | WriterException e ) {
			Logger.logError ( e.getMessage () + "\n" );
		}

		return ( MatrixToImageWriter.toBufferedImage ( bitMatrix ) );
	}

	public static void codeCreatorQuestions () throws IOException {
		Logger.log ("codeCreatorQuestions\n");

		int codeNumber = codeNumberQuestion ();
		QRCodeData[] qrCodeDataArray = new QRCodeData[ codeNumber ];
		QRCodeExtended[] qrCodeExtendedArray = new QRCodeExtended[ codeNumber ];

		if (codeNumber == 1) {

		}
	}

	private static OneCodeData codeDataQuestions () throws IOException {
		Logger.log ("codeDataQuestions\n");
		OneCodeData oneCodeData = new OneCodeData ();

		return ( oneCodeData );
	}

	private static int codeNumberQuestion () throws IOException {
		try ( Scanner scanner = new Scanner ( System.in ) ) {
			int codeNumber;
			Logger.logAndPrint ( "How many codes do you wish to create?  Please enter your answer in the same format " +
					"as \"1\".\n" );
			codeNumber = ( scanner.nextInt () );
			Logger.log ( codeNumber + "\n" );
			if (codeNumber < 0) {
				Logger.logAndPrint ( "You may not create fewer than 0 codes.\n" );
				codeNumber = codeNumberQuestion ();
			}
			return ( codeNumber );
		} catch ( Exception e ) {
			Logger.logError ( e.getMessage () + "\n" );
		}

		Logger.logError ( "codeNumberQuestion will return -1.\n" );
		return ( - 1 );
	}
}
