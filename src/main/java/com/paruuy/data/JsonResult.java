package com.paruuy.data;

import java.util.ArrayList;
import java.util.List;

public class JsonResult {

    private List<Nodes> result;

    public List<Nodes> getResult() {
        return result;
    }

    public void addNodes(Nodes nodes) {
        if (result == null) {
            result = new ArrayList<>();
        }
        this.result.add(nodes);
    }

}
