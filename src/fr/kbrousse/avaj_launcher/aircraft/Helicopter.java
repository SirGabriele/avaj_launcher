package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.my_exception.InternalException;

/**
 * Helicopter class
 */
public class Helicopter extends Aircraft {
    /**
     * Constructor
     * @param p_id          Id
     * @param p_name        Name
     * @param p_coordinates Coordinates
     */
    protected Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        this.type = "Helicopter";
    }

    /**
     * Update the Helicopter's coordinates depending on the weather
     * @throws InternalException If the weather found is invalid
     */
    @Override
    public void updateConditions() throws InternalException{
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                this.coordinates.increaseLongitude(5);
                System.out.println(this.getPrefix() + ": The Helicopter blades will cut the rain");
                break ;
            case "FOG":
                this.coordinates.increaseLongitude(1);
                System.out.println(this.getPrefix() + ": Fog so thick you could cut it with a blade");
                break ;
            case "SUN":
                this.coordinates.increaseLongitude(10);
                this.coordinates.increaseHeight(2);
                System.out.println(this.getPrefix() + ": I'm not a Helios-copter");
                break ;
            case "SNOW":
                this.coordinates.decreaseHeight(12);
                System.out.println(this.getPrefix() + ": I'm a heli-cold-pter");
                break ;
        }
        if (this.coordinates.getHeight() == 0) {
            System.out.println(this.getPrefix() + " landing.");
            this.weatherTower.unregister(this);
        }
    }
}
