package fr.kbrousse.avaj_launcher.main;

import fr.kbrousse.avaj_launcher.aircraft.Simulator;

public class Main {
    public static void main(String[] args) {
        if (Simulator.parseFile() != 0) {
            System.exit(1);
        }
        Simulator.launch();
    }
}