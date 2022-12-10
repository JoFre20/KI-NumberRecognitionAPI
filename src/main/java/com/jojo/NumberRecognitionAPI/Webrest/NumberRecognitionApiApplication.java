package com.jojo.NumberRecognitionAPI.Webrest;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import com.jojo.NumberRecognitionAPI.libary.OSHelper;
import com.jojo.NumberRecognitionAPI.libary.Server;

@SpringBootApplication
public class NumberRecognitionApiApplication {
	
	public static void start(String[] args) {
		SpringApplication app = new SpringApplication(new Class[] { NumberRecognitionApiApplication.class });
		if (OSHelper.isOnPC()) {
			app.setDefaultProperties(
					Collections.singletonMap("server.port", "8091"));
		    Server.println("[System] Devmode Active!");
		} else {
		     app.setDefaultProperties(
		           Collections.singletonMap("server.port", "8090"));
		} 
		app.run(args);
}

}
