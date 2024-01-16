package fr.kbrousse.avaj_launcher.Aircraft;

public class Helicopter extends Aircraft {
    /**
     * Constructor
     * @param p_id          Id
     * @param p_name        Name
     * @param p_coordinates Coordinates
     */
    protected Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        System.out.println("Constructor Helicopter");
    }

    /**
     * updateConditions
     */
    public void updateConditions() {}
}
