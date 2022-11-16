package com.jojo.NumberRecognitionAPI.CommandSystem;

public interface Command {
	
	public void run(String[] args);
	
	public String getName();
	
	public String getDesription();
	

}