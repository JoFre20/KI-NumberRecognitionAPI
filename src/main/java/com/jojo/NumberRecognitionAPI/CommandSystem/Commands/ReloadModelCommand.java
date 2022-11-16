package com.jojo.NumberRecognitionAPI.CommandSystem.Commands;

import com.jojo.NumberRecognitionAPI.Main;
import com.jojo.NumberRecognitionAPI.CommandSystem.Command;
import com.jojo.NumberRecognitionAPI.NeuralNetwork.Layer;
import com.jojo.NumberRecognitionAPI.NeuralNetwork.NeuralNetwork;
import com.jojo.NumberRecognitionAPI.lib.NeuralNetworkSave;
import com.jojo.NumberRecognitionAPI.libary.JsonHelper;
import com.jojo.NumberRecognitionAPI.libary.Server;

public class ReloadModelCommand implements Command {

	@Override
	public void run(String[] args) {
		Main.neuralnetwork = new NeuralNetwork();
		String Modeljson = Main.fileHelper.readFromDisk("files/Model.json");
		NeuralNetworkSave nns = JsonHelper.JsonToClass(Modeljson, NeuralNetworkSave.class);
		Main.neuralnetwork.init(nns.getNETWORK());
		Server.console("Model loaded Successfully!");
		Server.console("============");
		Server.console("Sample: " + nns.getSAMPLE());
		Server.console("Iterations: " + nns.getITERATIONS());
		Server.console("Created: " + nns.getCREATED());
		Server.console("============");
	}

	@Override
	public String getName() {
		return "ReloadModel";
	}

	@Override
	public String getDesription() {
		return "To reload the Current Model";
	}

}
