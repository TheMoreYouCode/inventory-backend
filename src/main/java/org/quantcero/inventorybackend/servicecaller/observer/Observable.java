package org.quantcero.inventorybackend.servicecaller.observer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Registers and unregisters plugins and services.
 */
public class Observable {

    private final ArrayList<Plugin> plugins;
    private final ArrayList<Service> services;
    private final HashMap<String, Service> commandServiceMapper;

    /**
     * Initializes observable.
     */
    public Observable() {
        plugins = new ArrayList<>();
        services = new ArrayList<>();
        commandServiceMapper = new HashMap<>();
    }

    /**
     * @param plugin plugin to register
     */
    public void register(Plugin plugin) {
        this.plugins.add(plugin);
    }

    /**
     * @param service service to register
     */
    public void register(Service service) {
        this.services.add(service);
        for (String command : service.getCommandList()) {
            if (!commandServiceMapper.containsKey(command)) {
                commandServiceMapper.put(command, service);
            } else {
                System.err.println("Overlapping on command \"" + command + "\"");
            }
        }
    }

    /**
     * @param plugin plugin to unregister
     */
    public void unregister(Plugin plugin) {
        this.plugins.remove(plugin);
    }

    /**
     * @param service service to unregister
     */
    public void unregister(Service service) {
        this.services.remove(service);
        for (String command : service.getCommandList()) {
            commandServiceMapper.remove(command);
        }
    }

    /**
     * @return iterable over all plugins
     */
    public Iterable<Plugin> getPlugins() {
        return plugins;
    }

    /**
     * @return iterable over all services
     */
    public Iterable<Service> getServices() {
        return services;
    }

    /**
     * @param command command that is requested
     * @return registered service or null
     */
    public Service getServiceForCommand(String command) {
        return commandServiceMapper.getOrDefault(command, null);
    }

}
