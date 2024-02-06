package fr.kbrousse.avaj_launcher.weather_provider;

import fr.kbrousse.avaj_launcher.aircraft.Coordinates;

/**
 * WeatherProvider class
 */
public class WeatherProvider {
    /**
     * Static instance of WeatherProvider
     */
    private static WeatherProvider instance = null;

    /**
     * Array of String containing the different possible weathers
     */
    private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    /**
     * Private default constructor
     */
    private WeatherProvider() {}

    /**
     * Getter of instance
     * @return WeatherProvider instance
     */
    public static synchronized WeatherProvider getInstance() {
        if (WeatherProvider.instance == null) {
            WeatherProvider.instance     = new WeatherProvider();
        }
        return (WeatherProvider.instance);
    }

    /**
     * Find the appropriate weather depending on the 3 coordinate points
     * @param p_coordinates Aircraft coordinates
     * @return String weather
     */
    public String getCurrentWeather(Coordinates p_coordinates) {
        // Generate a value between 0 and 3 from coordinates
        int value = Math.abs((p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4);
        return (this.weather[value]);
    }
}
