package com.viveksalvi.neuralnetworks.core;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    private List<Layer> layers = new ArrayList<>();

    public NeuralNetwork(int... conf) throws Exception{
        if(conf.length<3)
            throw new Exception("At least three layers are required!");

        for(int eachCount: conf){
            layers.add(new Layer(eachCount));
        }
    }
}
