package com.viveksalvi.neuralnetworks.core;


import java.util.ArrayList;
import java.util.List;

public class Neuron {

    private List<Connection> prevConnections = new ArrayList<>();
    private List<Connection> nextConnections = new ArrayList<>();
    private double value = 0;

    public Neuron(){}

    public Neuron(double value){
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void connect(Neuron nextNeuron, double weight){
        Connection con = new Connection(this, nextNeuron, weight);
        this.addNextConnection(con);
        nextNeuron.addPrevConnection(con);
    }

    public double getOutput(){
        if(this.prevConnections.size() == 0)
            return this.value;

        double output = 0;
        for(Connection eachPrevConnection: this.prevConnections){
            output += eachPrevConnection.output();
        }

        //Apply Activation
        return getActivatedOutput(output);
    }

    public void addPrevConnection(Connection prevConnection) {
        this.prevConnections.add(prevConnection);
    }

    public void addNextConnection(Connection nextConnection) {
        this.nextConnections.add(nextConnection);
    }

    private double getActivatedOutput(double output){
        if(this.prevConnections.size()>0) {
            return sigmoid(output);
        }

        return output;
    }

    private double sigmoid(double x){
        //*        1
        //* ---------------
        //*  1 + (e ^ (-x))

        double inverse_exponent = 1/Math.exp(x);
        double denominator = 1 + inverse_exponent;
        return 1/denominator;
    }

}
