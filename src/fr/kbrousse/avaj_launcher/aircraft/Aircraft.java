package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.flyable.Flyable;
import fr.kbrousse.avaj_launcher.my_exception.UnreachableException;

/**
 * Aircraft class
 */
public class Aircraft extends Flyable {
    /**
     * Aircraft ID
     */
    protected long id;

    /**
     * Aircraft name
     */
    protected String name;

    /**
     * Aircraft type
     */
    protected String type;

    /**
     * Aircraft coordinates
     */
    protected Coordinates coordinates;

    /**
     * Aircraft Constructor
     * @param p_id          Id
     * @param p_name        Name
     * @param p_coordinates Coordinates
     */
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    /**
     * Update Aircraft coordinates depending on the weather
     * @throws UnreachableException This code should not be reached
     */
    @Override
    public void updateConditions() throws Exception {
        throw new UnreachableException();
    }

    /**
     * Get the prefix required by the output
     * @return String prefix
     */
    @Override
    public String getPrefix() {
        return (this.type + '#' + this.name + '(' + this.id + ')');
    };

    /**
     * Getter of Aircraft type
     * @return String type
     */
    public String getType() {
        return (this.type);
    }

    /**
     * Getter of Aircraft coordinates
     * @return Coordinates object
     */
    public Coordinates getCoordinates() {
        return(this.coordinates);
    };
}
