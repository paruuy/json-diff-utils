package com.santander.data;

import java.util.ArrayList;
import java.util.List;

public class Nodes {

    private List<Node> nodes;
   
    public List<Node> getNodes() {
        return nodes;
    }
 
    public void addNode(Node node) {
        if(nodes == null){
            nodes = new ArrayList<>();
        }
        this.nodes.add(node);
    }
}
