package fr.kbrousse.avaj_launcher.Flyable;

import fr.kbrousse.avaj_launcher.WeatherTower.WeatherTower;

public abstract class Flyable {
    /**
     * WeatherTower attribute
     */
    protected WeatherTower _weatherTower;

    public abstract void updateConditions();

    /**
     * registerTower
     * @param p_tower WeatherTower to register to
     */
    public void registerTower(WeatherTower p_tower) {
        this._weatherTower = p_tower;
    }
}
