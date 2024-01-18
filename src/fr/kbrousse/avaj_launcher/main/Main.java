package fr.kbrousse.avaj_launcher.main;

import fr.kbrousse.avaj_launcher.aircraft.Simulator;
import fr.kbrousse.avaj_launcher.console_log.ConsoleLog;

import java.io.Console;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Only one argument should be given: the input file name
        if (args.length != 1) {
            System.out.println("Usage: java -cp out fr.kbrousse.avaj_launcher.main.Main <input file>");
            System.exit(1);
        }

        // Open the input file
        File file = new File(args[0]);
        // Verify its existence
        if (!file.exists()) {
            System.out.println("File '" + args[0] + "' can not be found");
            System.exit(1);
        }

        // Parse the file
        SimulationParameters params = Parser.parseFile(file);
        if (params == null) {
            System.exit(1);
        }

        try {
            // Launch the simulation
            Simulator.launch(params);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}