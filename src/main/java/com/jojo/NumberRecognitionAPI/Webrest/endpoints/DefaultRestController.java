package com.jojo.NumberRecognitionAPI.Webrest.endpoints;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.jojo.NumberRecognitionAPI.libary.Secure;
import com.jojo.NumberRecognitionAPI.libary.Server;

@Service
public class DefaultRestController implements IRestController {
    
    // Domain get code = ((""+request.getRequestURL()).split("/")[2].split(":")[0])

    public DefaultRestController() {
    	
    }

	@Override
	public ResponseEntity<String> status(HttpServletRequest request) {
        if(Secure.checkDomain(request)) {
            Server.println("[HttpClient] Status Check - Intern");
        	return ResponseEntity.ok("HEALTHY - INTERN");
        } else {
            Server.println("[HttpClient] Status Check - Extern");
            return ResponseEntity.ok("HEALTHY - EXTERN");
        }
	}

	@Override
	public ResponseEntity<String> askai(HttpServletRequest request, String image) {
        if(Secure.checkDomain(request)) {
        	return ResponseEntity.ok("OK");
        } else {
        	return ResponseEntity.ok("WRONG DOMAIN");
        }
	}
    	
}
