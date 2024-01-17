package fr.kbrousse.avaj_launcher.my_exception;

public class FileException extends Exception {
    /**
     * Red output color
     */
    public static final String RED = "\u001B[31m";

    /**
     * Reset output color
     */
    public static final String RESET = "\u001B[0m";

    /**
     * Default constructor
     */
    public FileException(String message) {
        super(RED + "Error: " + RESET + message);
    }
}
