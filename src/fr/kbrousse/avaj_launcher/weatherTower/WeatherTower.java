package fr.kbrousse.avaj_launcher.weatherTower;

import fr.kbrousse.avaj_launcher.aircraft.Coordinates;
import fr.kbrousse.avaj_launcher.tower.Tower;

public class WeatherTower extends Tower {
    /**
     * Default constructor
     */
    public WeatherTower() {
        System.out.println("Constructor WeatherTower");
    }

    /**
     * Getter for weather
     * @param p_coordinates Coordinates object
     * @return String weather
     */
    public String getWeather(Coordinates p_coordinates) {
        return ("a");
    }

    /**
     * ChangeWeather
     */
    public void changeWeather() {}
}