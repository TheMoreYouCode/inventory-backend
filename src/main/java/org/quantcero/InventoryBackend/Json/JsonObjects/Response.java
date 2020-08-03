package org.quantcero.InventoryBackend.Json.JsonObjects;

import java.util.HashMap;
import java.util.Map;

public abstract class Command {
    public String action = null;
    public String token = null;
    public Map<String, String> objects = new HashMap<String, String>();
}
