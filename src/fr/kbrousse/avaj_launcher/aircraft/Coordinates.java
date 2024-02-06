package fr.kbrousse.avaj_launcher.aircraft;

/**
 * Coordinates class
 */
public class Coordinates {
    /**
     * Longitude attribute
     */
    private int longitude;

    /**
     * Longitude attribute
     */
    private int latitude;

    /**
     * Height attribute
     */
    private int height;

    /**
     * Constructor
     * @param p_longitude   Longitude coordinate
     * @param p_latitude    Latitude coordinate
     * @param p_height      Height coordinate
     */
    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    /**
     * Getter for longitude
     * @return int
     */
    public int getLongitude() {return (this.longitude);}

    /**
     * Getter for latitude
     * @return int
     */
    public int getLatitude() {return (this.latitude);}

    /**
     * Getter for height
     * @return int
     */
    public int getHeight() {return (this.height);}

    /**
     * Increase longitude
     * @param p_value int value
     */
    public void increaseLongitude(int p_value) {
        this.longitude += p_value;
        if (this.longitude > 100) {
            this.longitude = 100;
        }
    }

    /**
     * Increase latitude
     * @param p_value int value
     */
    public void increaseLatitude(int p_value) {
        this.latitude += p_value;
        if (this.latitude > 100) {
            this.latitude = 100;
        }
    }

    /**
     * Increase height
     * @param p_value int value
     */
    public void increaseHeight(int p_value) {
        this.height += p_value;
        if (this.height > 100) {
            this.height = 100;
        }
    }

    /**
     * Decrease height
     * @param p_value int value
     */
    public void decreaseHeight(int p_value) {
        this.height -= p_value;
        if (this.height < 0) {
            this.height = 0;
        }
    }
}