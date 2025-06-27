package TaskManager;

import org.jetbrains.annotations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public  class TaskManagerOperation {
    public static String[][] loadDataToTab(String fileName) {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            return null;
        }
        try {
            List<String> lines = Files.readAllLines(path);
            String[][] data = new String[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                data[i] = lines.get(i).split(";");
                System.out.println((i + 1) + ". " + line);
            }
            return data;

        } catch (IOException e) {
            System.out.println("Cannot read the file: " + e.getMessage());
            return null;
    }
}
public static void printOptions(String @NotNull [] tab) {
    System.out.println(pl.coderslab.ConsoleColors.BLUE);
    System.out.println("Please choose one of the following options: " + pl.coderslab.ConsoleColors.RESET);
    for (String option : tab) {
        System.out.println(option);

    }
}
}


