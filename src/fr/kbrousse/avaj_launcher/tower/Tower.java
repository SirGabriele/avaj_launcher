package fr.kbrousse.avaj_launcher.tower;

import fr.kbrousse.avaj_launcher.flyable.Flyable;

import java.util.ArrayList;
import java.util.List;

/**
 * Tower class
 */
public class Tower {
    /**
     * List of Flyable registered to this Tower
     */
    private List<Flyable> observers;

    /**
     * Constructor
     */
    public Tower() {
        this.observers = new ArrayList<>();
    }

    /**
     * Getter of observers
     * @return List of Flyable
     */
    public final List<Flyable> getObservers() {
        return (this.observers);
    }

    /**
     * Register a flyable object
     * @param p_flyable Flyable object to register
     */
    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.getPrefix() + " registered to weather tower.");
    }

    /**
     * Unregister a flyable object
     * @param p_flyable Flyable object to unregister
     */
    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
        System.out.println("Tower says: " + p_flyable.getPrefix() + " unregistered from weather tower.");
    }

    /**
     * Apply the current weather conditions to each registered aircraft
     * @throws Exception If the weather found is invalid
     */
    protected void conditionChanged() throws Exception {
        if (this.getObservers().isEmpty()) {
            return ;
        }
        // Make a copy so that we can remove an element of the list if necessary while iterating through it
        List<Flyable> copy = new ArrayList<>(this.getObservers());
        for (Flyable f : copy) {
            f.updateConditions();
        }
    }
}
