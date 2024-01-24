package fr.kbrousse.avaj_launcher.weatherTower;

import fr.kbrousse.avaj_launcher.aircraft.Coordinates;
import fr.kbrousse.avaj_launcher.tower.Tower;
import fr.kbrousse.avaj_launcher.weather_provider.WeatherProvider;

/**
 * WeatherTower class
 */
public class WeatherTower extends Tower {
        /**
     * Default constructor
     */
    public WeatherTower() {
    }

    /**
     * Getter for weather
     * @param p_coordinates Coordinates object
     * @return String weather
     */
    public String getWeather(Coordinates p_coordinates) {
        return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
    }

    /**
     * Change the weather of all aircraft
     * @throws Exception If the weather found is invalid
     */
    public void changeWeather() throws Exception {
        this.conditionChanged();
    }
}