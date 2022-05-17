package com;

public class Main {

	//args [0] is the path of the file the codes will be put in.
	//args [1] is the datatype.
	//args [2] is the version.
	//args [3] is the error correction.
	//args [4+] are the Strings to turn into codes.
	public static void main (String [] args) {
		for (int a = 4; a < args.length; a++) {
			makeCode (args [a], args [0], args [1], args [2], args [4]);
		}
	}

	public static void makeCode (String input, String filePath, String datatype, String version, String errorCorrection) {
		try {
			
		}
		catch (Exception e) {
			System.err.println (e);
		}
	}
}
