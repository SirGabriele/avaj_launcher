package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.my_exception.InternalException;

/**
 * Baloon class
 */
public class Baloon extends Aircraft {
    /**
     * Constructor
     * @param p_id          Id
     * @param p_name        Name
     * @param p_coordinates Coordinates
     */
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        this.type = "Baloon";
    }

    /**
     * Update the Baloon's coordinates depending on the weather
     * @throws InternalException If the weather found is invalid
     */
    @Override
    public void updateConditions() throws InternalException{
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                this.coordinates.decreaseHeight(5);
                System.out.println(this.getPrefix() + ": My baloon is wet");
                break ;
            case "FOG":
                this.coordinates.decreaseHeight(3);
                System.out.println(this.getPrefix() + ": Baloon in the fog makes a funny log");
                break ;
            case "SUN":
                this.coordinates.increaseLongitude(2);
                this.coordinates.increaseHeight(4);
                System.out.println(this.getPrefix() + ": My baloon is hot");
                break ;
            case "SNOW":
                this.coordinates.decreaseHeight(15);
                System.out.println(this.getPrefix() + ": There is snow on the baloon");
                break ;
        }
        if (this.coordinates.getHeight() == 0) {
            System.out.println(this.getPrefix() + " landing.");
            this.weatherTower.unregister(this);
        }
    }
}
