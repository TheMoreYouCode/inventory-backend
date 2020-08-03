package org.quantcero.inventorybackend.json.jsonobjects;

import org.quantcero.inventorybackend.json.Converter;

import java.util.HashMap;
import java.util.Map;

public class Command {
    public String action;
    public String token;
    public Map<String, String> objects;

    public Command(String action) {
        this.action = action;
        this.token = "";
        this.objects = new HashMap<>();
    }

    public Command(String action, String token) {
        this.action = action;
        this.token = token;
        this.objects = new HashMap<>();
    }

    public Command(String action, Map<String, String> objects) {
        this.action = action;
        this.token = "";
        this.objects = objects;
    }

    public Command(String action, String token, Map<String, String> objects) {
        this.action = action;
        this.token = token;
        this.objects = objects;
    }

    @Override
    public String toString() {
        return Converter.getConverter().parseCommand(this);
    }
}
