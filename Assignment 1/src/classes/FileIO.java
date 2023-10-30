package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileIO {

    /**
     * write content into a file if file not found, create a new file. if file
     * exits override content.
     *
     * @param filePath patch of the file, If file is in the same project only
     * need file name
     * @param content : content which will be written
     */
    public static boolean writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }

    /**
     * write append content into a file if file not found, create a new file.
     *
     * @param filePath patch of the file, If file is in the same project only
     * need file name
     * @param content : content which will be written
     */
    public static boolean appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
            return false;
        }
    }

    /**
     * readFile: read all content of the file. Return a String
     *
     * @param filePath patch of the file, If file is in the same project only
     * need file name
     * @return String
     */

    public static String readFile(String filePath) {
        //Use StringBuilder for faster reading File
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                //add the system-dependent line separator string ex:in Window is '\r\n'
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        // return a String convert system-dependent line to '\n'
        return content.toString();
    }
}
