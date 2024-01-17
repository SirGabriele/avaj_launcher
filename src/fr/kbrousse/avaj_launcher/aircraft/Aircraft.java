package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.flyable.Flyable;

public class Aircraft extends Flyable {
    /**
     * Id attribute
     */
    protected long id;

    /**
     * Name attribute
     */
    protected String name;

    /**
     * Coordinate attribute
     */
    protected Coordinates coordinates;

    /**
     * Constructor
     * @param p_id          Id
     * @param p_name        Name
     * @param p_coordinates Coordinates
     */
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {}

    /**
     * updateConditions
     */
    @Override
    public void updateConditions() {}
}
