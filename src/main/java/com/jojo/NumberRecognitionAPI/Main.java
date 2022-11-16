package com.jojo.NumberRecognitionAPI;

import java.util.Collections;

import org.springframework.boot.SpringApplication;

import com.jojo.NumberRecognitionAPI.CommandSystem.CommandRegister;
import com.jojo.NumberRecognitionAPI.CommandSystem.ConsoleReader;
import com.jojo.NumberRecognitionAPI.CommandSystem.Commands.HelpCommand;
import com.jojo.NumberRecognitionAPI.Webrest.NumberRecognitionApiApplication;
import com.jojo.NumberRecognitionAPI.libary.OSHelper;
import com.jojo.NumberRecognitionAPI.libary.Server;

public class Main {
	
	public static CommandRegister commandregister = new CommandRegister();
	
	
	public static void main(String[] args) {
		ConsoleReader consolereader = new ConsoleReader();
		consolereader.start();
		
		commandregister.register("help", new HelpCommand());
		
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
