package org.quantcero.inventorybackend.json;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.quantcero.inventorybackend.json.jsonobjects.Command;
import org.quantcero.inventorybackend.json.jsonobjects.Response;

import java.util.HashMap;

/**
 * Convert to and from json.
 *
 * @author Simon Deckwert
 */
public class Converter {

    private static Converter converter;
    private Gson gsonParser;

    private Converter() {
        gsonParser = new Gson();
    }

    /**
     * @return a singleton converter object
     */
    public static Converter getConverter() {
        if (converter == null) {
            converter = new Converter();
        }
        return converter;
    }

    /**
     * @param json input from remote
     * @return command object
     */
    public Command parseRawCommand(String json) {
        try {
            return gsonParser.fromJson(json, Command.class);
        } catch (JsonSyntaxException e) {
            return new Command("syntaxerror", new HashMap<>());
        }
    }

    /**
     * @param response response from backend
     * @return json
     */
    public String parseResponse(Response response) {
        return gsonParser.toJson(response, Response.class);
    }

    /**
     * @param command parsed command
     * @return json
     */
    public String parseCommand(Command command) {
        return gsonParser.toJson(command, Command.class);
    }

}
