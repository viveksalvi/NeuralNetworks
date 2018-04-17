package com.viveksalvi.neuralnetworks.core;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    private List<Layer> layers = new ArrayList<>();
    private int[] conf = {2,3,2};

    public NeuralNetwork(int... conf) throws Exception{
        if(conf.length < 3)
            throw new Exception("At least three layers are required! INPUT, HIDDEN and OUTPUT");

        this.conf = conf;
        // Initialize each layer
        for(int eachCount : conf){
            layers.add(new Layer(eachCount));
        }

        // Connect All the layers
        for(int i = 0; i < layers.size() - 1; i++){
            layers.get(i).connect(layers.get(i+1));
        }
    }

    public double[] feedForward(int[] inputs) throws Exception{

        int inputSize = this.conf[0];
        int outputSize = this.conf[conf.length-1];

        if(inputs.length != inputSize)
            throw  new Exception("Number of inputs must be same as specified in NN configuration : " + inputSize);

        double[] output = new double[this.conf[conf.length-1]];

        //Setup input connections
        for(int i = 0; i < inputSize; i++){
            Connection con = new Connection(null, this.layers.get(0).getNeurons().get(i) , inputs[i]);
            this.layers.get(0).getNeurons().get(i).addPrevConnection(con);
        }

        //Collect outputs
        for(int i = 0; i < outputSize; i++){
            Layer lastLayer = this.layers.get(this.conf[this.conf.length-1]);
            output[i] = lastLayer.getNeurons().get(i).getOutput();
        }

        return output;
    }
}
