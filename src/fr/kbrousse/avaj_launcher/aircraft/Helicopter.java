package fr.kbrousse.avaj_launcher.aircraft;

public class Helicopter extends Aircraft {
    /**
     * Constructor
     * @param p_id          Id
     * @param p_name        Name
     * @param p_coordinates Coordinates
     */
    protected Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    /**
     * updateConditions
     */
    public void updateConditions() {}
}
