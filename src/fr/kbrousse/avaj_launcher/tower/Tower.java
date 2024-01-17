package fr.kbrousse.avaj_launcher.tower;

import fr.kbrousse.avaj_launcher.flyable.Flyable;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    //commentaire à faire
    private List<Flyable> _observers;

    /**
     * Default constructor
     */
    public Tower() {
        System.out.println("Constructor Tower");
        this._observers = new ArrayList<>();
    }

    /**
     * Register
     * @param p_flyable Flyable object to register
     */
    public void register(Flyable p_flyable) {
        this._observers.add(p_flyable);
    }

    /**
     * Unregister
     * @param p_flyable Flyable object to unregister
     */
    public void unregister(Flyable p_flyable) {
        this._observers.remove(p_flyable);
    }

    /**
     * ConditionChanged
     */
    protected void conditionChanged() {}
}
