package org.quantcero.inventorybackend.servicecaller.observer;

import org.quantcero.inventorybackend.json.jsonobjects.Command;
import org.quantcero.inventorybackend.json.jsonobjects.Response;

import java.util.Collection;

public abstract class Service {

    private Observable observable;

    public void activate(Observable observable) {
        this.observable = observable;
        observable.register(this);
    }

    public void deactivate() {
        observable.unregister(this);
        this.observable = null;
    }

    public abstract Response update(Command command);

    public abstract Collection<String> getCommandList();

}
