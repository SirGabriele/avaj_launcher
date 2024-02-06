package fr.kbrousse.avaj_launcher.parser;

import fr.kbrousse.avaj_launcher.main.SimulationParameters;
import fr.kbrousse.avaj_launcher.my_exception.FileException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * Parser class
 */
public class Parser {
    /**
     * Private default constructor
     */
    private Parser() {}

    /**
     * Parse the file
     * @param file input file
     * @return int number of simulations
     */
    public static SimulationParameters parseFile(File file) {
        String[]    allLines;
        int         nbOfSimulation;

        try (FileInputStream inStream = new FileInputStream(file)) {
            // Write the whole file content into a buffer
            byte[] buffer = new byte[(int) file.length()];
            if (inStream.read(buffer) == -1) {
                throw new FileException("Could not read file");
            }

            // Convert the buffer into a String and then split on every newline
            allLines = new String(buffer).split("\n");

            // Extract the number on the first line
            nbOfSimulation = Parser.parseFirstLine(allLines[0]);

            // Modify allLines so that it only contains the aircraft information
            allLines = Arrays.copyOfRange(allLines, 1, allLines.length);

            Parser.parseBody(allLines);
            return (new SimulationParameters(nbOfSimulation, allLines));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return (null);
        }
    }

    /**
     * Parse the first line of the file
     * @param s string to parse
     * @throws FileException When the number of simulation is invalid
     * @return int number of simulations
     */
    public static int parseFirstLine(String s) throws FileException{
        // Trim the String to get rid of all useless whitespaces
        s = s.trim();
        if (!s.matches("\\d+")) {
            throw new FileException("Invalid number of simulation to run: " + s);
        }
        return (Integer.parseInt(s));
    }

    /**
     * Parse the body of the file
     * @param s array containing all aircraft data
     * @throws FileException When body has an invalid format
     */
    public static void parseBody(String[] s) throws FileException {
        for (int i = 0; i < s.length; ++i) {
            if (!s[i].trim().matches("[A-Za-z]+\\s[A-Za-z0-9]+\\s[0-9]+\\s[0-9]+\\s([0-9]|[1-9][0-9]|100)")) {
                throw new FileException("Invalid body - Line " + i + ": " + s[i] + '\n' +
                        "Format is: <type> <name> <latitude> <longitude> <height from 0 to 100>");
            }
        }
    }
}

