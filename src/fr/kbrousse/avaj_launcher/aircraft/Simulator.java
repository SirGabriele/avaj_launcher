package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.flyable.Flyable;
import fr.kbrousse.avaj_launcher.main.SimulationParameters;
import fr.kbrousse.avaj_launcher.my_exception.FileException;
import fr.kbrousse.avaj_launcher.tower.Tower;

public class Simulator {
    /**
     * Default constructor
     */
    private Simulator() {
    }

    /**
     * Launch the whole simulation
     * This block of code is within a try block placed in Main.java
     */
    public static void launch(SimulationParameters params) throws FileException {
        Simulator._createAircrafts(params.getAllAircrafts());
    }

    private static void _createAircrafts(final String[] allAircrafts) throws FileException {
        // Index starts at 1 because allAircrafts contains the first line of the file, which is not an aircraft data
        for (int i = 1; i < allAircrafts.length; ++i) {
            final String[]    info = allAircrafts[i].split("\\s");
            final String      type = info[0];
            final String      name = info[1];
            final int         longitude = Integer.parseInt(info[2]);
            final int         latitude = Integer.parseInt(info[3]);
            final int         height = Integer.parseInt(info[4]);

            // Create new instance of Flyable
            Flyable object = AircraftFactory
                    .getInstance()
                    .newAircraft(type, name, new Coordinates(longitude, latitude, height));
            if (object == null) {
                throw new FileException("Unknown type requested");
            }
        }
    }
}