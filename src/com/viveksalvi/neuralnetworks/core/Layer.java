package com.viveksalvi.neuralnetworks.core;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private List<Neuron> neurons = new ArrayList<>();

    public Layer(int neuronsCount){
        for(int i = 0; i < neuronsCount; i++){
            neurons.add(new Neuron());
        }
    }

    public List<Neuron> getNeurons() {
        return neurons;
    }

    public void connect(Layer nextLayer){
        for(Neuron eachThisNeuron: this.neurons){
            for(Neuron eachNextLayerNeuron: nextLayer.getNeurons()){
                eachThisNeuron.connect(eachNextLayerNeuron, Utility.getRandomDouble());
            }
        }
    }
}
