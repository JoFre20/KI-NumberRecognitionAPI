package com.jojo.NumberRecognitionAPI.libary;

import javax.servlet.http.HttpServletRequest;

public class Secure {
	
	private static String domain1 = "backend.nummererkennung.de";
	private static String domain2 = "127.0.0.1";
	
	public static boolean checkDomain(HttpServletRequest request) {
		if(((""+request.getRequestURL()).split("/")[2].split(":")[0]) == domain1|| ((""+request.getRequestURL()).split("/")[2].split(":")[0]).equals(domain1) || ((""+request.getRequestURL()).split("/")[2].split(":")[0]) == domain2|| ((""+request.getRequestURL()).split("/")[2].split(":")[0]).equals(domain2)) {
			return true;
		} else {
			return false;
		}
	}

}
