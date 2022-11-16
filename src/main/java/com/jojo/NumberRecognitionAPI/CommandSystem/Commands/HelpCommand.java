package com.jojo.NumberRecognitionAPI.CommandSystem.Commands;

import java.util.Map.Entry;

import com.jojo.NumberRecognitionAPI.Main;
import com.jojo.NumberRecognitionAPI.CommandSystem.Command;
import com.jojo.NumberRecognitionAPI.libary.Server;

public class HelpCommand implements Command {

	@Override
	public void run(String[] args) {
		Server.console("Help Page:");
		for(Entry<String, Command> entry : Main.commandregister.getCommands().entrySet()) {
		    String key = entry.getKey();
		    Command value = entry.getValue();
		    
		    Server.console("  " + value.getName() + " - " + value.getDesription() + " #" + key);
		    
		}
	}

	@Override
	public String getName() {
		return "HelpCommand";
	}

	@Override
	public String getDesription() {
		return "Displays a HelpList";
	}

}