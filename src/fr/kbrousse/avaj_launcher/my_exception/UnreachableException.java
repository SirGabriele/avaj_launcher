package fr.kbrousse.avaj_launcher.my_exception;

import fr.kbrousse.avaj_launcher.output_colors.OutputColors;

/**
 * UnreachableException class
 */
public class UnreachableException extends Exception implements OutputColors {
    /**
     * Default constructor
     */
    public UnreachableException() {
        super(RED + "Error: " + RESET + "This code should not be reached");
    }
}
