package com.jojo.NumberRecognitionAPI.libary;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.jojo.NumberRecognitionAPI.Main;

public class ImageHelper {
	
	public static ArrayList<Float> getImageData(String imgname) throws IOException {
		FastRGB fastRGB = new FastRGB(ImageIO.read(Main.fileHelper.readFromDiskFile(imgname)));
		ArrayList<Float> image = new ArrayList<Float>();
		for (int w = 0; w < fastRGB.getWidth(); w++) {
			for (int h = 0; h < fastRGB.getHeight(); h++) {
				int rgb = fastRGB.getRGB(w, h);
				int r = (rgb >> 16) & 0xFF;
				int g = (rgb >> 8) & 0xFF;
				int b = (rgb & 0xFF);
				int gray = (r + g + b) / 3;
				if(gray < 60) {
					gray = 0;
				}
				image.add(normalizeMINST(gray));
			}
		}
		return image;
	}
	
    private static float normalizeMINST(float value) {
    	return value / 255;
    }

}
