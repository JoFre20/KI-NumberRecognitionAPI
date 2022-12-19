package com.jojo.NumberRecognitionAPI.CommandSystem.Commands;

import com.jojo.NumberRecognitionAPI.Main;
import com.jojo.NumberRecognitionAPI.CommandSystem.Command;
import com.jojo.NumberRecognitionAPI.libary.Server;
import com.jojo.NumberRecognitionAPI.libary.Status;

public class SetStatusCommand implements Command {

	@Override
	public void run(String[] args) {
		String service_str = args[1].toUpperCase();
		String status_str = args[2].toUpperCase();
		Status status = Status.valueOf(status_str);
		if(service_str.equals("KI")) {
			Main.KI_Status = status;
			Server.console("The Service 'KI-Backend' was set to '" + status.toString() + "'");
			return;
		} else if(service_str.equals("IMG")) {
			Main.IMG_Status = status;
			Server.console("The Service 'NummerDatabase' was set to '" + status.toString() + "'");
			return;
		}
		Server.console("Pls use one of the Services: [KI,IMG]");
	}

	@Override
	public String getName() {
		return "Set Status of Service";
	}

	@Override
	public String getDesription() {
		return "to set the Status of a Service";
	}

}
