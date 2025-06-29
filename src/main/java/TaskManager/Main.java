package TaskManager;

import pl.coderslab.ConsoleColors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static TaskManager.TaskManagerOperation.loadDataToTab;
import static TaskManager.TaskManagerOperation.printOptions;
import static TaskManager.TaskOptionsOperation.*;


public class Main {
    static String[][] tasks;

    static final String FILE_NAME = "./tasks.csv";

    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    public static void main(String[] args) throws IOException {
        tasks = loadDataToTab(FILE_NAME);
        if (tasks == null) {
            System.out.println(pl.coderslab.ConsoleColors.RED);
            System.out.println("No file found" + pl.coderslab.ConsoleColors.RESET);
            return;
        }
        printOptions(OPTIONS);
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter the option you choose: " + pl.coderslab.ConsoleColors.RESET);
        String option = scanner.nextLine();

        while (!option.equals("exit")) {
        if (option.equals("add")) {
            tasks = addTask(tasks);
            tasks = loadDataToTab(FILE_NAME);
       }
       else if (option.equals("remove")) {
            tasks = removeTask(tasks, scanner);


       } else if (option.equals("list")) {
           tasks = loadDataToTab(FILE_NAME);

       }
        else {
           System.out.println("Invalid option");
        }

            printOptions(OPTIONS);
            System.out.println(ConsoleColors.YELLOW);
            System.out.println("\nEnter the option you choose: " + pl.coderslab.ConsoleColors.RESET);
            option = scanner.nextLine();
        }
        exitProgram();
    }
}
