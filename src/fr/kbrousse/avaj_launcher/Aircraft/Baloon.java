package fr.kbrousse.avaj_launcher.Aircraft;

public class Baloon extends Aircraft {
    /**
     * Constructor
     * @param p_id          Id
     * @param p_name        Name
     * @param p_coordinates Coordinates
     */
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        System.out.println("Constructor Baloon");
    }

    /**
     * updateConditions
     */
    public void updateConditions() {}
}
