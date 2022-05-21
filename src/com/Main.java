package com;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	//args [0] is the path of the file the codes will be put in.
	//args [1] is the datatype.
	//args [2] is the error correction.
	//args [3] is the version.
	//args [4] is the size.
	//args [4+] are the names, followed by the Strings to turn into codes, followed by whether or not those strings are names of files to turn into codes.
	public static void main (String [] args) {
		for (int a = 7; a < args.length; a += 3) {
			makeCode (args [0], args [1], args [2], args [3], args [4], args [a - 2], args [a - 1], args [a]);
		}
	}

	public static void makeCode (String filePath, String datatype, String errorCorrection, String version, String size, String name, String input, String isFile) {
		int width = 0;
		int height = 0;

		if (size.substring(0, 1).equals("(")) {
			Scanner scanner = new Scanner (size);
			width = scanner.nextInt();
			height = scanner.nextInt();
		}
		else {
			width = Integer.parseInt (size);
			height = Integer.parseInt (size);
		}

		String helperInput = "";
		BufferedImage code = makeCodeHelper(width, height, errorCorrection, version, helperInput);
	}

	public static BufferedImage makeCodeHelper (int width, int height, String errorCorrection, String version, String input) {
		BitMatrix bitMatrix = new BitMatrix (width, height);

		Map <EncodeHintType, String> map = new EnumMap <> (EncodeHintType.class);
		map.put (EncodeHintType.ERROR_CORRECTION, errorCorrection);
		map.put (EncodeHintType.QR_VERSION, version);

		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter ();
			bitMatrix = qrCodeWriter.encode (input, BarcodeFormat.QR_CODE, width, height, map);
		}
		catch (Exception e) {
			System.err.println (e);
		}

		return (MatrixToImageWriter.toBufferedImage(bitMatrix));
	}
}

//Parts of this were made using the following tutorial.
//https://www.youtube.com/watch?v=MP7Yrvb8LrA
