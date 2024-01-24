package fr.kbrousse.avaj_launcher.flyable;

import fr.kbrousse.avaj_launcher.weatherTower.WeatherTower;

/**
 * Flyable class
 */
public abstract class Flyable {
    /**
     * The Weather Tower to which this Flyable is registered to
     */
    protected WeatherTower weatherTower;

    /**
     * Protected default constructor
     */
    protected Flyable() {}

    /**
     * Update the Flyable's coordinates depending on the weather
     * @throws Exception If the weather found is invalid
     */
    public abstract void updateConditions() throws Exception;

    /**
     * Get the prefix required by the output
     * @return String prefix
     */
    public abstract String getPrefix();

    /**
     * Initiate the weatherTower attribute to the weatherTower instance this Flyable object is registered to
     * @param p_tower WeatherTower to register to
     */
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }
}
