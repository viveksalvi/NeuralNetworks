package com.viveksalvi.neuralnetworks.core;


import java.util.ArrayList;
import java.util.List;

public class Neuron {

    private List<Connection> prevConnections = new ArrayList<>();
    private List<Connection> nextConnections = new ArrayList<>();

    public List<Connection> getPrevConnections() {
        return prevConnections;
    }

    public List<Connection> getNextConnections() {
        return nextConnections;
    }

    public void connect(Neuron nextNeuron, double weight){
        Connection con = new Connection(this, nextNeuron, weight);
        this.getNextConnections().add(con);
        nextNeuron.getPrevConnections().add(con);
    }

    public double getOutput(){
        double output = 0;
        for(Connection eachPrevConnection: this.prevConnections){
            output += eachPrevConnection.output();
        }
        return output;
    }
}
