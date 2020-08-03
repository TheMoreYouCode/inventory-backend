package org.quantcero.inventorybackend.json.jsonobjects;

import org.quantcero.inventorybackend.json.Converter;

import java.util.HashMap;
import java.util.Map;

public class Response {

    public int returnCode;
    public String response;
    public Map<String, String> objects;

    public Response() {
        this.returnCode = 200;
        this.response = "";
        this.objects = new HashMap<>();
    }

    public Response(String response) {
        this.returnCode = 200;
        this.response = response;
        this.objects = new HashMap<>();
    }

    public Response(int returnCode, String response) {
        this.returnCode = returnCode;
        this.response = response;
        this.objects = new HashMap<>();
    }

    public Response(String response, Map<String, String> objects) {
        this.returnCode = 200;
        this.response = response;
        this.objects = objects;
    }

    public Response(int returnCode, String response, Map<String, String> objects) {
        this.returnCode = returnCode;
        this.response = response;
        this.objects = objects;
    }

    @Override
    public String toString() {
        return Converter.getConverter().parseResponse(this);
    }

}
