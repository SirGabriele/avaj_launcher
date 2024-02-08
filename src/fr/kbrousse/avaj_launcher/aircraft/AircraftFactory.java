package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.flyable.Flyable;
import fr.kbrousse.avaj_launcher.my_exception.FileException;

/**
 * AircraftFactory class
 */
public class AircraftFactory {
    /**
     * Number of Aircraft object attribute
     */
    public static long nextID = 1;

    /**
     * Static instance of AircraftFactory
     */
    public static AircraftFactory instance;

    /**
     * Private default constructor
     */
    private AircraftFactory() {}

    /**
     * Create a new Aircraft object
     * @param p_type Object type
     * @param p_name Object name
     * @param p_coordinates Object coordinates
     * @throws FileException If the requested type is unknown or if the amount of aircraft created is too high
     * @return Flyable object or null if the type is unknown
     */
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws FileException {
        // Since the type is case-insensitive, toLowerCase it to have a uniform input
        Flyable object = switch (p_type.toLowerCase()) {
            case "baloon" -> new Baloon(AircraftFactory.nextID, p_name, p_coordinates);
            case "jetplane" -> new JetPlane(AircraftFactory.nextID, p_name, p_coordinates);
            case "helicopter" -> new Helicopter(AircraftFactory.nextID, p_name, p_coordinates);
            default -> null;
        };

        // If the AircraftFactory successfully created an object, increment the id count
        if (object != null) {
            AircraftFactory.nextID++;
        } else {
            throw new FileException("Unknown type requested");
        }
        // Set a limit of Long.MAX_VALUE - 1 IDs to handle a possible counter overflow
        if (AircraftFactory.nextID == Long.MAX_VALUE - 1) {
            throw new FileException("AircraftFactory can not provide you that many aircraft. There is a raw material shortage");
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
