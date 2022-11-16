package com.jojo.NumberRecognitionAPI.NeuralNetwork;

import java.util.HashMap;

public class NeuralNetwork {
	
	private static Layer[] layers;
	
	public static void init(Layer[] layersinput) {
		layers = layersinput;
	}
	
	public static int recognitionNumber(float[] datainput) {
//        System.out.println("0 -- " + layers[3].neurons[0].value);
//        System.out.println("1 -- " + layers[3].neurons[1].value);
//        System.out.println("2 -- " + layers[3].neurons[2].value);
//        System.out.println("3 -- " + layers[3].neurons[3].value);
//        System.out.println("4 -- " + layers[3].neurons[4].value);
//        System.out.println("5 -- " + layers[3].neurons[5].value);
//        System.out.println("6 -- " + layers[3].neurons[6].value);
//        System.out.println("7 -- " + layers[3].neurons[7].value);
//        System.out.println("8 -- " + layers[3].neurons[8].value);
//        System.out.println("9 -- " + layers[3].neurons[9].value);
    	HashMap<Float, Integer> outputs = new HashMap<Float, Integer>();
        forward(datainput);
        outputs.put(layers[3].neurons[0].value, 0);
        outputs.put(layers[3].neurons[1].value, 1);
        outputs.put(layers[3].neurons[2].value, 2);
        outputs.put(layers[3].neurons[3].value, 3);
        outputs.put(layers[3].neurons[4].value, 4);
        outputs.put(layers[3].neurons[5].value, 5);
        outputs.put(layers[3].neurons[6].value, 6);
        outputs.put(layers[3].neurons[7].value, 7);
        outputs.put(layers[3].neurons[8].value, 8);
        outputs.put(layers[3].neurons[9].value, 9);
        
        //System.out.println(JsonHelper.ClassToJson(layers));
        return StatUtil.getMaxEntryInMapBasedOnKey(outputs).getValue();
	}
    
    public static void forward(float[] inputs) {
    	layers[0] = new Layer(inputs);
    	
        for(int i = 1; i < layers.length; i++) {
        	for(int j = 0; j < layers[i].neurons.length; j++) {
        		float sum = 0;
        		for(int k = 0; k < layers[i-1].neurons.length; k++) {
        			sum += layers[i-1].neurons[k].value*layers[i].neurons[j].weights[k];
        		}
        		sum += layers[i].neurons[j].bias;
        		layers[i].neurons[j].value = StatUtil.Sigmoid(sum);
        	}
        } 	
    }
}
