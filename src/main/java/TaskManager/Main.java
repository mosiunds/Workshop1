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
        System.out.println("Please enter the option you choose: ");
        String option = scanner.nextLine();
        if (option.equals("add")) {
            tasks = addTask(tasks);

       }
       else if (option.equals("remove")) {
           tasks = removeTask(tasks,0);
//        } else if (option.equals("list")) {
//            listTasks(tasks);
//        }
//        else {
//            System.out.println("Invalid option");
//        }
//    }
//


        }
    }
}
