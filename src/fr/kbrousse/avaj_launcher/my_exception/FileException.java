package fr.kbrousse.avaj_launcher.my_exception;

import fr.kbrousse.avaj_launcher.output_colors.OutputColors;

/**
 * FileException class
 */
public class FileException extends Exception implements OutputColors {
    /**
     * Default constructor
     * @param message String message
     */
    public FileException(String message) {
        super(RED + "Error: " + RESET + message);
    }
}
