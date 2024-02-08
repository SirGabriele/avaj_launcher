package fr.kbrousse.avaj_launcher.main;

import fr.kbrousse.avaj_launcher.aircraft.Simulator;
import fr.kbrousse.avaj_launcher.parser.Parser;
import fr.kbrousse.avaj_launcher.output_colors.OutputColors;
import fr.kbrousse.avaj_launcher.writer.Writer;

import java.io.File;

/**
 * Main class
 */
public class Main implements OutputColors {

    /**
     * Private default constructor
     */
    private Main() {}

    /**
     * Program entry point
     * @param args The input file
     */
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
            System.out.println(RED + "Error: " + RESET + "File '" + args[0] + "' can not be found");
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
            // By closing it, print the buffer content into the file
            Writer.getInstance().closeWriter();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}