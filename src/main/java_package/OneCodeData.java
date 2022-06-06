package main.java_package;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;

public class OneCodeData {
	private String filePath;
	private String datatype;
	private String errorCorrection;
	private ErrorCorrectionLevel errorCorrectionECL;
	private String version;
	private String width;
	private int widthInt;
	private String height;
	private int heightInt;
	private String name;
	private String string;
	private String isFile;
	private boolean isFileBoolean;

	public String getFilePath () {
		return filePath;
	}

	public void setFilePath ( String filePath ) {
		this.filePath = filePath;
	}

	public String getDatatype () {
		return datatype;
	}

	public void setDatatype ( String datatype ) {
		this.datatype = datatype;
	}

	public String getErrorCorrection () {
		return errorCorrection;
	}

	public void setErrorCorrection ( String errorCorrection ) throws IOException {
		this.errorCorrection = errorCorrection;
		errorCorrectionECL = Main.stringToECL (errorCorrection);
	}

	public void setErrorCorrection (ErrorCorrectionLevel errorCorrection) {
		errorCorrectionECL = errorCorrection;
		this.errorCorrection = errorCorrection.toString ();
	}

	public String getVersion () {
		return version;
	}

	public void setVersion ( String version ) {
		this.version = version;
	}

	public String getWidth () {
		return width;
	}

	public void setWidth ( String width ) {
		this.width = width;
		widthInt = Integer.parseInt ( width );
	}

	public void setWidth ( int width ) {
		widthInt = width;
		this.width = String.valueOf ( width );
	}

	public String getHeight () {
		return height;
	}

	public void setHeight ( String height ) {
		this.height = height;
		heightInt = Integer.parseInt ( height );
	}

	public void setHeight ( int height ) {
		heightInt = height;
		this.height = String.valueOf ( height );
	}

	public String getName () {
		return name;
	}

	public void setName ( String name ) {
		this.name = name;
	}

	public String getString () {
		return string;
	}

	public void setString ( String string ) {
		this.string = string;
	}

	public String getIsFile () {
		return isFile;
	}

	public void setIsFile ( String isFile ) {
		isFileBoolean = Boolean.parseBoolean ( isFile );
		this.isFile = isFile;
	}

	public void setIsFile (boolean isFile) {
		isFileBoolean = isFile;
		this.isFile = String.valueOf ( isFile );
	}

	public OneCodeData () {

	}
}
