package com.viveksalvi.neuralnetworks.core;

public class Connection {

    private double weight;
    private Neuron prevNeuron, nextNeuron;

    public Connection(Neuron prevNeuron, Neuron nextNeuron, double weight){
        this.weight = weight;
        this.prevNeuron = prevNeuron;
        this.nextNeuron = nextNeuron;
    }

    public double getWeight() {
        return weight;
    }

    public Neuron getPrevNeuron() {
        return prevNeuron;
    }

    public Neuron getNextNeuron() {
        return nextNeuron;
    }

    public double output(){
        return (this.getPrevNeuron().getOutput() * this.getWeight());
    }
}
