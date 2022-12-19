package com.jojo.NumberRecognitionAPI;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jojo.NumberRecognitionAPI.CommandSystem.CommandRegister;
import com.jojo.NumberRecognitionAPI.CommandSystem.ConsoleReader;
import com.jojo.NumberRecognitionAPI.CommandSystem.Commands.HelpCommand;
import com.jojo.NumberRecognitionAPI.CommandSystem.Commands.ReloadModelCommand;
import com.jojo.NumberRecognitionAPI.CommandSystem.Commands.SetStatusCommand;
import com.jojo.NumberRecognitionAPI.NeuralNetwork.NeuralNetwork;
import com.jojo.NumberRecognitionAPI.Webrest.NumberRecognitionApiApplication;
import com.jojo.NumberRecognitionAPI.lib.NeuralNetworkSave;
import com.jojo.NumberRecognitionAPI.libary.FileHelper;
import com.jojo.NumberRecognitionAPI.libary.JsonHelper;
import com.jojo.NumberRecognitionAPI.libary.OSHelper;
import com.jojo.NumberRecognitionAPI.libary.Server;
import com.jojo.NumberRecognitionAPI.libary.Status;

@SpringBootApplication
public class Main {
	
	public static CommandRegister commandregister = new CommandRegister();
	public static FileHelper fileHelper = new FileHelper();
	public static NeuralNetwork neuralnetwork = new NeuralNetwork();
	
	public static Status KI_Status = Status.ONLINE;
	public static Status IMG_Status = Status.ONLINE;
	
	public static void main(String[] args) {
		ConsoleReader consolereader = new ConsoleReader();
		consolereader.start();
		
		commandregister.register("help", new HelpCommand());
		commandregister.register("reloadmodel", new ReloadModelCommand());
		commandregister.register("setstatus", new SetStatusCommand());
		
		fileHelper.init();
		String Modeljson = fileHelper.readFromDisk("files/Model.json");
		NeuralNetworkSave nns = JsonHelper.JsonToClass(Modeljson, NeuralNetworkSave.class);
		Main.neuralnetwork.init(nns.getNETWORK());
		Server.console("Model loaded Successfully!");
		Server.console("============");
		Server.console("Sample: " + nns.getSAMPLE());
		Server.console("Iterations: " + nns.getITERATIONS());
		Server.console("Created: " + nns.getCREATED());
		Server.console("============");
		
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
