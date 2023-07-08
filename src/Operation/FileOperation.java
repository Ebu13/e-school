package Operation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {
    // Create a text file
    public static void createTextFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("Text file created: " + filePath);
            } else {
                System.out.println("Text file already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the text file: " + e.getMessage());
        }
    }

    // Delete a text file
    public static void deleteTextFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Text file deleted: " + filePath);
            } else {
                System.out.println("An error occurred while deleting the text file.");
            }
        } else {
            System.out.println("Text file does not exist.");
        }
    }

    // Read data from a text file
    public static String readDataFromTextFile(String filePath) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading data from the text file: " + e.getMessage());
        }
        return data.toString();
    }

    // Write text to a file
    public static void writeTextToFile(String fileName, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);
            System.out.println("Text successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}