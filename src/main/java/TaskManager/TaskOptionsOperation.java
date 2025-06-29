package TaskManager;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import pl.coderslab.ConsoleColors;

import javax.management.Descriptor;
import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static TaskManager.Main.FILE_NAME;

public class TaskOptionsOperation {
    static Path path = Paths.get(FILE_NAME);

    public static String[][] addTask(String[][] tasks) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] newTask = {"Description", "DueDate", "Importance"};
        System.out.print("Enter description: ");
        newTask[0] = scanner.nextLine();
        System.out.print("Enter dueDate: ");
        newTask[1] = scanner.nextLine();
        System.out.print("Enter importance(true/false): ");
        newTask[2] = scanner.nextLine();
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = newTask;
        System.out.println("Task " + (tasks.length) + " added");

        String newLine = String.join(", ", newTask) + System.lineSeparator();
        Files.writeString(path, newLine, StandardOpenOption.APPEND);
        return tasks;
    }

    public static String[][] removeTask(String[][] tasks, Scanner scanner) {
        if (ArrayUtils.isEmpty(tasks)) {
            System.out.println("There are no tasks to remove from.");
            return tasks;
        }
        boolean validInput = false;
        int taskNumber = -1;

        while (!validInput) {
            System.out.println(ConsoleColors.YELLOW);
            System.out.println("Please enter the task number you would like to remove" + ConsoleColors.RESET);
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                exitProgram();
                }
            try {
                taskNumber = (Integer.parseInt(input) - 1);
                if (taskNumber >= tasks.length || taskNumber <= 0) {
                    System.out.println(ConsoleColors.RED_BOLD + "There is no task with number " + (taskNumber + 1)+ ConsoleColors.RESET);
                }
                else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println(ConsoleColors.RED_BOLD);
                System.out.println("Invalid input. Please provide a number greater than 0 " + ConsoleColors.RESET);
                scanner.nextLine();
            }
        }
            System.out.println("Task " + (taskNumber + 1) + " removed");
            String[][] updatedTasks = ArrayUtils.remove(tasks, taskNumber);

            try (FileWriter fileWriter = new FileWriter(FILE_NAME, false)) { // This is to discuss
                for (String[] row : updatedTasks) {
                    fileWriter.write(String.join(";", row));
                    fileWriter.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return updatedTasks;
        }
        public static void exitProgram() {
            System.out.println(ConsoleColors.BLUE_BOLD);
            System.out.println("\nExiting program. Goodbye!" + pl.coderslab.ConsoleColors.RESET);
            System.exit(0);
        }
    }



