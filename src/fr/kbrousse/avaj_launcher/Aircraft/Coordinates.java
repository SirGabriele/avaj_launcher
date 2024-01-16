package fr.kbrousse.avaj_launcher.Aircraft;

public class Coordinates {
    /**
     * Longitude attribute
     */
    private int _longitude;

    /**
     * Longitude attribute
     */
    private int _latitude;

    /**
     * Height attribute
     */
    private int _height;

    /**
     * Constructor
     * @param p_longitude   Longitude coordinate
     * @param p_latitude    Latitude coordinate
     * @param p_height      Height coordinate
     */
    Coordinates(int p_longitude, int p_latitude, int p_height) {
        System.out.println("Constructor Coordinates");
        this._longitude = p_longitude;
        this._latitude = p_latitude;
        this._height = p_height;
    }

    /**
     * Getter for longitude
     * @return int
     */
    public int getLongitude() {return (this._longitude);}

    /**
     * Getter for latitude
     * @return int
     */
    public int getLatitude() {return (this._latitude);}

    /**
     * Getter for height
     * @return int
     */
    public int getHeight() {return (this._height);}
}
