package com.jojo.NumberRecognitionAPI.CommandSystem;

import java.util.Scanner;

import com.jojo.NumberRecognitionAPI.Main;

public class ConsoleReader extends Thread {
	
	public ConsoleReader() {
		this.setName("ConsoleReaderThread");
	}
	
	public void run() {
		while(true) {
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();
			if(!s.isEmpty()) {
				Main.commandregister.run(s);
			}
		}
	}
}