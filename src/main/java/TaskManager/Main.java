package TaskManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import static TaskManager.TaskManagerOperation.loadDataToTab;
import static TaskManager.TaskManagerOperation.printOptions;
import static TaskManager.TaskOptionsOperation.addTask;
import static TaskManager.TaskOptionsOperation.removeTask;


public class Main {
    static String[][] tasks;

    static final String FILE_NAME = "./tasks.csv";

    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    public static void main(String[] args) throws IOException {
        tasks = loadDataToTab(FILE_NAME);
        if (tasks == null) {
            System.out.println("No file found");
            return;
        }
        printOptions(OPTIONS);
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the option you choose: ");
        String option = scanner.nextLine();

        while (!option.equals("exit")) {
        if (option.equals("add")) {
            tasks = addTask(tasks);
            tasks = loadDataToTab(FILE_NAME);
       }
       else if (option.equals("remove")) {
            tasks = removeTask(tasks, 0);
            tasks = loadDataToTab(FILE_NAME);

       } else if (option.equals("list")) {
           tasks = loadDataToTab(FILE_NAME);

       }
        else {
           System.out.println("Invalid option");
        }

            printOptions(OPTIONS);
            System.out.println("\nEnter the option you choose: ");
            option = scanner.nextLine();
        }
        System.out.println("\nExiting program. Goodbye!");
        scanner.close();
    }
}
