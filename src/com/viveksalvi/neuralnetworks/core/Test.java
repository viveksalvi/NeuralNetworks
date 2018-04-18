package com.viveksalvi.neuralnetworks.core;

public class Test {

    public static void main(String[] args) throws Exception{
        NeuralNetwork nn = new NeuralNetwork(new int[]{3,2,3}, 0.5);
        double[] outputs = nn.feedForward(new double[]{7,3,5});
        for(double output : outputs){
            System.out.println(output);
        }
    }

}
