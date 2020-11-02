package projekt1;
import org.junit.Test;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileSave {

    static void Zapisz(String pesel) {
        try {
            Files.write(Paths.get("pesele.txt"), (pesel + "\n").getBytes(), StandardOpenOption.APPEND);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}