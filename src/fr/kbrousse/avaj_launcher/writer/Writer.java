package fr.kbrousse.avaj_launcher.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer class
 */
public class Writer {
    /**
     * Static instance of Writer
     */
    private static Writer instance = null;

    /**
     * Name of the output file
     */
    private final static String OUTPUT_FILE_NAME = "simulation.txt";

    /**
     * File attribute
     */
    private static final File outputFile = new File(OUTPUT_FILE_NAME);

    /**
     * Static instance of Writer
     */
    private static BufferedWriter writer = null;

    /**
     * Private default constructor
     */
    private Writer() throws IOException {
        if (writer == null) {
            // Initialize the writer
            // Create the file or erase the content of the existing one
            writer = new BufferedWriter(new FileWriter(outputFile));
        }
    }

    /**
     * Getter of instance
     * @return Writer instance
     * @throws IOException If the creation failed
     */
    public static synchronized Writer getInstance() throws IOException {
        if (Writer.instance == null) {
            Writer.instance = new Writer();
        }
        return (Writer.instance);
    }

    /**
     * Write a string to the output file
     * @param string String to write
     * @throws IOException If the writing operation failed
     */
    public void writeToFile(final String string) throws IOException {
        writer.write(string + "\n");
    }

    /**
     * Close the Writer. By doing so, print the buffer content into the file
     * @throws IOException Il the close failed
     */
    public void closeWriter() throws IOException {
        writer.close();
    }
}
