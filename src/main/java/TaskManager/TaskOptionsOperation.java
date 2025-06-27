package TaskManager;

import org.apache.commons.lang3.ArrayUtils;

import javax.management.Descriptor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

import static TaskManager.Main.FILE_NAME;

public class TaskOptionsOperation {
    public static String[][] addTask(String[][] tasks) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] newTask = {"Description", "DueDate", "Importance"};
        System.out.print("Enter description: ");
        newTask[0] = scanner.nextLine();
        System.out.print("Enter dueDate: ");
        newTask[1] = scanner.nextLine();
        System.out.print("Enter importance(high/normal): ");
        newTask[2] = scanner.nextLine();
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = newTask;
        System.out.println("Task " + (tasks.length) + " added");

        for (int i = 0; i < tasks.length; i++) {
        System.out.println((i + 1) + ". " + String.join(", ", tasks[i]));
        }
        Path path = Paths.get(FILE_NAME);
        String newLine = String.join(";", newTask) + System.lineSeparator();
        Files.writeString(path, newLine, StandardOpenOption.APPEND);
        return tasks;
    }

    public static String[][] removeTask(String[][] tasks, int taskNumber) {
        Scanner scanner = new Scanner(System.in);
        if (ArrayUtils.isEmpty(tasks)) {
            System.out.println("There are no tasks to remove from.");
            return tasks;
        }
        System.out.println("Please enter the task number you would like to remove");
        taskNumber = (scanner.nextInt() - 1);
        if (taskNumber >= tasks.length) {
            System.out.println("There is no task with number " + taskNumber);
            return tasks;
        }
        System.out.println("Task " + (taskNumber + 1) + " removed");
        return ArrayUtils.remove(tasks, taskNumber);
    }

    public static String [][] listTasks (String [][] tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the task number you would like to list");
        if (ArrayUtils.isEmpty(tasks)) {
            System.out.println("There are no tasks to list.");
            return tasks;
        }
        if (tasks.length > tasks.length) {
            System.out.println("There is no task with number " + tasks.length);
        }
        return (tasks);
    }



}



