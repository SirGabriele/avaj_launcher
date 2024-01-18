package fr.kbrousse.avaj_launcher.main;

import fr.kbrousse.avaj_launcher.aircraft.Simulator;

public class SimulationParameters {
    /**
     * Array of String containing all aircrafts to be made
     */
    private String[]    allAircrafts;

    /**
     * Number of times the simualtion should be run
     */
    private int         nbOfSimulation;

    /**
     * Constructor
     * @param p_nbOfSimulation Number of simulations to run
     * @param p_allAircrafts String array containing all aircrafts
     */
    public SimulationParameters(int p_nbOfSimulation, String[] p_allAircrafts) {
        this.nbOfSimulation = p_nbOfSimulation;
        this.allAircrafts = p_allAircrafts;
    }

    /**
     * Getter of allAircrafts
     * @return String[] allAircrafts
     */
    public final String[] getAllAircrafts() {
        return (this.allAircrafts);
    }

    /**
     * Getter of nbOfSimulation
     * @return int nbOfSimulation
     */
    public final int getNbOfSimulation() {
        return (this.nbOfSimulation);
    }
}
