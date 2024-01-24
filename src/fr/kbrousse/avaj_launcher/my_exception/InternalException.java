package fr.kbrousse.avaj_launcher.my_exception;

import fr.kbrousse.avaj_launcher.output_colors.OutputColors;

/**
 * InternalException class
 */
public class InternalException extends Exception implements OutputColors {
    /**
     * Default constructor
     * @param message String message
     */
    public InternalException(String message) {
        super(RED + "Error: " + RESET + message);
    }
}
