package com.viveksalvi.neuralnetworks.core;

public class Connection {

    private double weight;
    private Neuron prevNeuron, nextNeuron;

    public Connection(Neuron prevNeuron, Neuron nextNeuron, double weight){
        this.weight = weight;
        this.prevNeuron = prevNeuron;
        this.nextNeuron = nextNeuron;
    }

    public double output(){
        return (this.prevNeuron==null)?this.weight:(this.prevNeuron.getOutput() * this.weight);
    }
}
