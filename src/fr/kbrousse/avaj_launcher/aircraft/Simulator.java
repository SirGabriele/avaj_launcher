package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.flyable.Flyable;
import fr.kbrousse.avaj_launcher.main.SimulationParameters;
import fr.kbrousse.avaj_launcher.my_exception.FileException;
import fr.kbrousse.avaj_launcher.tower.WeatherTower;

/**
 * Simulator class
 */
public class Simulator {
    /**
     * Private default constructor
     */
    private Simulator() {}

    /**
     * Launch the whole simulation
     * This block of code is within a try block placed in Main.java
     * @param params An instance of the SimulationParameters class
     * @throws Exception If the file contains an invalid information
     */
    public static void launch(SimulationParameters params) throws Exception {
        final WeatherTower weatherTower = Simulator._createAircraft(params.getAllAircraft());

        int limit = params.getNbOfSimulation();
        // Loop for the required number of times
        for (int i = 0; i < limit; ++i) {
            weatherTower.changeWeather();
        }

    }

    /**
     * Create a weatherTower object the list of which contains all the different Flyable objects created from the input file
     * @param allAircraft Body of the input file
     * @return WeatherTower instance
     * @throws FileException If the file contains an invalid information
     */
    private static WeatherTower _createAircraft(final String[] allAircraft) throws Exception {
        final WeatherTower weatherTower = new WeatherTower();
        for (String s : allAircraft) {
            final String[] info = s.split("\\s");
            final String type = info[0];
            final String name = info[1];
            final int longitude = Integer.parseInt(info[2]);
            final int latitude = Integer.parseInt(info[3]);
            final int height = Integer.parseInt(info[4]);

            // Create new instance of Flyable
            Flyable object = AircraftFactory
                    .getInstance()
                    .newAircraft(type, name, new Coordinates(longitude, latitude, height));
            // Register the Flyable object to the weatherTower
            object.registerTower(weatherTower);
            // Register the weatherTower to the Flyable object
            weatherTower.register(object);
        }
        return (weatherTower);
    }
}