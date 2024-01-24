package fr.kbrousse.avaj_launcher.main;

/**
 * SimulationParameters class
 */
public class SimulationParameters {
    /**
     * Array of String containing all aircraft to be made
     */
    private final String[] allAircraft;

    /**
     * Number of times the simulation should be run
     */
    private final int nbOfSimulation;

    /**
     * Default Constructor
     * @param p_nbOfSimulation Number of simulations to run
     * @param p_allAircraft String array containing all aircrafts
     */
    public SimulationParameters(int p_nbOfSimulation, String[] p_allAircraft) {
        this.nbOfSimulation = p_nbOfSimulation;
        this.allAircraft = p_allAircraft;
    }

    /**
     * Getter of allAircraft
     * @return String[] allAircraft
     */
    public final String[] getAllAircraft() {
        return (this.allAircraft);
    }

    /**
     * Getter of nbOfSimulation
     * @return int nbOfSimulation
     */
    public final int getNbOfSimulation() {
        return (this.nbOfSimulation);
    }
}
