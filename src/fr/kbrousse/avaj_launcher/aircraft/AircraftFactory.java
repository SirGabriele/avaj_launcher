package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.flyable.Flyable;
import fr.kbrousse.avaj_launcher.my_exception.FileException;

public class AircraftFactory {
    /**
     * Number of Aircraft object attribute
     */
    public static int nbOfAircraft = 0;

    public static AircraftFactory instance;

    /**
     * Default constructor
     */
    private AircraftFactory() {}

    /**
     * Create a new Aircraft object
     * @param p_type Object type
     * @param p_name Object name
     * @param p_coordinates Object coordinates
     * @return Flyable object or null if the type is unknown
     */
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        Flyable object = switch (p_type) {
            case "Baloon" -> new Baloon(AircraftFactory.nbOfAircraft, p_name, p_coordinates);
            case "JetPlane" -> new JetPlane(AircraftFactory.nbOfAircraft, p_name, p_coordinates);
            case "Helicopter" -> new Helicopter(AircraftFactory.nbOfAircraft, p_name, p_coordinates);
            default -> null;
        };

        // if the AircraftFactory successfully created an object, increment the id count
        if (object != null) {
            AircraftFactory.nbOfAircraft++;
        }
        return (object);
    }

    /**
     * Getter of instance
     * @return AircraftFactory instance
     */
    public static synchronized AircraftFactory getInstance() {
        if (AircraftFactory.instance == null) {
            AircraftFactory.instance = new AircraftFactory();
        }
        return AircraftFactory.instance;
    }
}
