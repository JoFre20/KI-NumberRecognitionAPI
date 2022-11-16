package com.jojo.NumberRecognitionAPI.CommandSystem;

import java.util.HashMap;

import com.jojo.NumberRecognitionAPI.libary.Server;

public class CommandRegister {
	
	private static HashMap<String,Command> commands = new HashMap<String,Command>();
	
	public static void register(String command, Command clazz) {
		if(!commands.containsKey(command)) {
			commands.put("/" + command, clazz);
		}
	}
	
	public static void run(String command) {
		if(!commands.isEmpty() && command.startsWith("/")) {
			String[] args = command.split(" ");
			if(commands.containsKey(args[0])) {
				commands.get(args[0]).run(args);
			} else {
				Server.console("This Command does not Exist for Help Type '/help'.");
			}
		}
	}
	
	public static HashMap<String, Command> getCommands() {
		return commands;
	}

}