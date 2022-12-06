package com.jojo.NumberRecognitionAPI.lib;

public class MNISTImageSave {
	
	private String IMAGEDATA;
	private int NUMBER;
	
	public MNISTImageSave(String imageData, int number) {
		this.IMAGEDATA = imageData;
		this.NUMBER = number;
	}
	
	public String getIMAGEDATA() {
		return IMAGEDATA;
	}
	
	public int getNUMBER() {
		return NUMBER;
	}

}
