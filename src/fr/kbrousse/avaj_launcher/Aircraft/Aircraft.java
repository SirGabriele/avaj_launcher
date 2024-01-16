package fr.kbrousse.avaj_launcher.Aircraft;

import fr.kbrousse.avaj_launcher.Flyable.Flyable;

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
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        System.out.println("Constructor Aircraft");
    }

    /**
     * updateConditions
     */
    @Override
    public void updateConditions() {}
}
