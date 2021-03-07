package com.santander.jsondiff;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.MapDifference.ValueDifference;
import com.santander.data.JsonResult;
import com.santander.data.Node;
import com.santander.data.Nodes;
import com.santander.utils.FlatMapUtil;

public class JsonDiffApp {
    public static void main(String[] args) throws IOException {

        String json1 = "";
        String json2 = "";

        if(args.length == 2){
            json1 = args[0];
            json2 = args[1];
        }else{
            json1 = "{\"name\":\"Mike\", \"city\":\"Lisbon\", \"state\":\"Lisbon\"}";
            json2 = "{\"city\":\"New York\", \"street\":\"20 Cooper Square\", \"name\":\"John\"}";
        }
        
      
        System.out.println(compareJsonDiff(json1, json2));

    }

    public static String compareJsonDiff(String json1, String json2) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> type = new TypeReference<HashMap<String, Object>>() {
        };

        Map<String, Object> leftMap = mapper.readValue(json1, type);
        Map<String, Object> rightMap = mapper.readValue(json2, type);

        //Se os items acima tem listas dentro o FlatMapUtil nivela tudo para ficar uma lista so 
        Map<String, Object> leftFlatMap = FlatMapUtil.flatten(leftMap);
        Map<String, Object> rightFlatMap = FlatMapUtil.flatten(rightMap);

        //Metodos da dependencia Guava para comparar ambos JSONs
        MapDifference<String, Object> difference = Maps.difference(leftFlatMap, rightFlatMap);

        JsonResult resultList = new JsonResult();
        for (Map.Entry<String, ValueDifference<Object>> entry : difference.entriesDiffering().entrySet()){
            String key = entry.getKey();
            ValueDifference<Object> values = entry.getValue();
            String left = (values.leftValue()!=null) ? values.leftValue().toString() : "";
            String right = (values.rightValue()!=null) ? values.rightValue().toString() : "";

            Nodes nodes = new Nodes();
            nodes.addNode(new Node(key,left, "JSON_1"));
            nodes.addNode(new Node(key,right, "JSON_2"));
            resultList.addNodes(nodes);            
        }

        ObjectMapper objectMapper  = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(resultList);

        //System.out.println();
        return jsonString;
    } 

}
