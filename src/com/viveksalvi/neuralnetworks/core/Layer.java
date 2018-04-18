package com.viveksalvi.neuralnetworks.core;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private List<Neuron> neurons = new ArrayList<>();

    public Layer(int neuronsCount) throws Exception{
        for(int i = 0; i < neuronsCount; i++){
            if(i>0)
                neurons.add(new Neuron());
            else
                neurons.add(new Neuron());
        }
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void connect(Layer nextLayer, double bias) throws Exception{
        for(Neuron eachThisNeuron: this.neurons){
            for(Neuron eachNextLayerNeuron : nextLayer.getNeurons()){
                eachThisNeuron.connect(eachNextLayerNeuron, Utility.getRandomDouble());
            }
        }

        //Add bias neuron
        Neuron biasNeuron = new Neuron(bias);
        for(Neuron eachNextLayerNeuron : nextLayer.getNeurons()){
            biasNeuron.connect(eachNextLayerNeuron, Utility.getRandomDouble());
        }
    }

}
