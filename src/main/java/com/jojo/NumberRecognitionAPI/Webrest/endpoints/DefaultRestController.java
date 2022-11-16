package com.jojo.NumberRecognitionAPI.Webrest.endpoints;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class DefaultRestController implements IRestController {
    
    private Gson gson = new Gson();
    
    // Domain get code = ((""+request.getRequestURL()).split("/")[2].split(":")[0])

    public DefaultRestController() {
    	
    }

	@Override
	public ResponseEntity<String> status(HttpServletRequest paramHttpServletRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> askai(HttpServletRequest paramHttpServletRequest, String image) {
		// TODO Auto-generated method stub
		return null;
	}
    	
}
