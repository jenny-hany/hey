package filehandlingexample;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {

    // Read all data from a file into a list of strings
    public static List<String> readFromFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        return data;
    }


    // Write data to a file (overwrite or append based on a flag)
    public static void writeToFile(String fileName, List<String> data, boolean append) {
        try (FileWriter writer = new FileWriter(fileName, append)) {
            for (String line : data) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
