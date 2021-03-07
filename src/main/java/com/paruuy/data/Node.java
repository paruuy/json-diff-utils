package com.paruuy.data;

public class Node {

    private String path;
    private String value;
    private String json_source;

    public String getPath() {
        return path;
    }

    public String getValue() {
        return value;
    }

    public String getJson_source() {
        return json_source;
    }

    public Node(String path, String value, String json_source) {
        this.path = path;
        this.value = value;
        this.json_source = json_source;
    }


}
