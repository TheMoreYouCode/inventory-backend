package org.quantcero.inventorybackend.servicecaller;

import org.quantcero.inventorybackend.json.jsonobjects.Command;
import org.quantcero.inventorybackend.json.jsonobjects.Response;
import org.quantcero.inventorybackend.servicecaller.observer.Observable;
import org.quantcero.inventorybackend.servicecaller.observer.Plugin;
import org.quantcero.inventorybackend.servicecaller.observer.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Gets the user command and calls the plugins and services.
 */
public class ServiceCaller extends Observable {

    /**
     * @param command command object from
     * @return response from service
     */
    public Response call(Command command) {

        for (Plugin plugin : getPlugins()) {
           plugin.update(command);
        }

        final Service service = getServiceForCommand(command.action);
        final Response response;
        if (service != null) {
            response = service.update(command);
        } else {
            response = new Response(404, "Command not registered", new HashMap<>());
        }

        for (Plugin plugin : getPlugins()) {
            plugin.update(response);
        }

        return response;

    }

    /**
     * Load all plugins and tell them to register.
     */
    public void loadPlugins() {
        ServiceLoader<Plugin> pluginLoader = ServiceLoader.load(Plugin.class);
        pluginLoader.stream().map(ServiceLoader.Provider::get).sorted().forEach(plugin -> plugin.activate(this));
    }

    /**
     * Load all services and tell them to register.
     */
    public void loadServices() {
        ServiceLoader<Service> serviceLoader = ServiceLoader.load(Service.class);
        serviceLoader.stream().map(ServiceLoader.Provider::get).sorted().forEach(plugin -> plugin.activate(this));
    }

}
