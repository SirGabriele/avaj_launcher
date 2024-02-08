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
            // Create a buffer of size file.length()
            byte[] buffer = new byte[(int)file.length()];

            // Read file content into a buffer
            if (inStream.read(buffer) == -1) {
                throw new FileException("Could not read file");
            }

            // If file is empty
            if (buffer.length == 0) {
                throw new FileException("File is empty");
            }

            // Convert the buffer into a String, trim it and then split on every newline
            allLines = new String(buffer).trim().split("\n");

            // Extract the number on the first line
            nbOfSimulation = Parser.parseFirstLine(allLines[0]);

            // Get rid of the first line so that allLines only contains the aircraft information
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
            throw new FileException("Invalid value - Line 1: " + s + '\n' + "Require int");
        }
        return (Integer.parseInt(s));
    }

    /**
     * Parse the body of the file
     * @param s array containing all aircraft data
     * @throws FileException When body has an invalid format
     */
    public static void parseBody(String[] s) throws FileException {
        if (s.length == 0) {
            throw new FileException("Invalid body - Empty");
        }
        for (int i = 0; i < s.length; ++i) {
            if (!s[i].trim().matches("[A-Za-z]+\\s[A-Za-z0-9]+\\s[0-9]+\\s[0-9]+\\s([0-9]|[1-9][0-9]|100)")) {
                throw new FileException("Invalid body - Line " + i + ": " + s[i] + '\n' +
                        "Format is: <type> <name> <latitude> <longitude> <height from 0 to 100>");
            }
        }
    }
}

