package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.my_exception.InternalException;
import fr.kbrousse.avaj_launcher.writer.Writer;
/**
 * JetPlane class
 */
public class JetPlane extends Aircraft {
    /**
     * Constructor
     * @param p_id          Id
     * @param p_name        Name
     * @param p_coordinate Coordinates
     */
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        this.type = "JetPlane";
    }

    /**
     * Update the JetPlane's coordinates depending on the weather
     * @throws InternalException If the weather found is invalid
     */
    @Override
    public void updateConditions() throws Exception {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                this.coordinates.increaseLatitude(5);
                Writer.getInstance().writeToFile(this.getPrefix() + ": It's raining but in a JetPlane it does not really matter");
                break ;
            case "FOG":
                this.coordinates.increaseLatitude(1);
                Writer.getInstance().writeToFile(this.getPrefix() + ": I can't see ship (it's a JetPlane joke when there is fog)");
                break ;
            case "SUN":
                this.coordinates.increaseLatitude(10);
                this.coordinates.increaseHeight(2);
                Writer.getInstance().writeToFile(this.getPrefix() + ": It's hot in this metal JetPlane");
                break ;
            case "SNOW":
                this.coordinates.decreaseHeight(7);
                Writer.getInstance().writeToFile(this.getPrefix() + ": It's snowing but in a JetPlane you don't care");
                break ;
        }
        if (this.coordinates.getHeight() == 0) {
            Writer.getInstance().writeToFile(this.getPrefix() + " landing.");
            this.weatherTower.unregister(this);
        }
    }
}
