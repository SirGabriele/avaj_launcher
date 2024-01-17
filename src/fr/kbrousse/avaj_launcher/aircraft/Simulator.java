package fr.kbrousse.avaj_launcher.aircraft;

import fr.kbrousse.avaj_launcher.flyable.Flyable;
import fr.kbrousse.avaj_launcher.my_exception.FileException;

import java.io.File;
import java.util.Scanner;

public class Simulator {
    /**
     * Default constructor
     */
    private Simulator() {}

    /**
     * Launch the whole simulation
     * This block of code is within a try block placed in Main.java
     */
    public static void launch() {
        final String[]  allTypes = {"Baloon", "JetPlane", "Helicopter", "a"};
        String          type = allTypes[0];
        String          name = "Jojo";
        int             longitude = 1;
        int             latitude = 2;
        int             height = 3;
        Coordinates     coordinates = new Coordinates(longitude, latitude, height);

        try {
            // create new Flyable object from the input file
            Flyable object = AircraftFactory
                    .getInstance()
                    .newAircraft(type, name, coordinates);
            if (object == null) {
                throw new FileException("Unknown type requested");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int parseFile() {
        //String fileName = "scenario.txt";
        String fileName = "emptyFile.txt";

        try {
            // open the file
            File file = new File(fileName);

            if (!file.exists()) {
                throw new FileException("File '" + fileName + "' can not be found");
            }

            Scanner scanner = new Scanner(file);
            if (!scanner.hasNextLine()) {
                throw new FileException("File is empty");
            }

            // read each line
            String line = scanner.nextLine();
            // MUST PROCESS THE FIRST LINE----------------------------
            while (line.isEmpty()) {
                System.out.println(line);
                // MUST PROCESS EACH LINE----------------------------
                line = scanner.nextLine();
            }
            System.out.println("file empty");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return (1);
        }
        return (0);
    }
}
