package org.quantcero.inventorybackend.servicecaller.observer;

import org.quantcero.inventorybackend.json.jsonobjects.Command;
import org.quantcero.inventorybackend.json.jsonobjects.Response;

public abstract class Plugin {

    private Observable observable;

    /**
     * Start observing the observable.
     *
     * @param observable observable to observe
     */
    public void activate(Observable observable) {
        this.observable = observable;
        observable.register(this);
    }

    /**
     * Stop observing the observable.
     */
    public void deactivate() {
        observable.unregister(this);
        this.observable = null;
    }

    public abstract void update(Command command);

    public abstract void update(Response response);

}
