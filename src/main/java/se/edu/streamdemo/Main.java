package se.edu.streamdemo;

import se.edu.streamdemo.data.Datamanager;
import se.edu.streamdemo.task.Deadline;
import se.edu.streamdemo.task.Task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Task manager (using streams)");
        Datamanager dataManager = new Datamanager("./data/data.txt");
        ArrayList<Task> tasksData = dataManager.loadData();

//        System.out.println("Printing all data ...");
//        printAllData(tasksData);
        printByStream(tasksData);

//        System.out.println("Printing deadlines ...");
//        printDeadlines(tasksData);
        printDeadlinesByStream(tasksData);
        System.out.println("Total number of deadlines: " + countDeadlinesByStream(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static int countDeadlinesByStream(ArrayList<Task> tasksData) {
        int count = (int) tasksData.stream()
                    .filter(t -> t instanceof Deadline)
                    .count();
        return count;
    }

    public static void printAllData(ArrayList<Task> tasksData) {
        System.out.println("Printing by iteration");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printByStream(ArrayList<Task> tasksData) {
        System.out.println("Printing by stream");
        tasksData.stream()
                    .forEach(System.out::println);
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        System.out.println("Printing deadlines");
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesByStream(ArrayList<Task> tasksData) {
        System.out.println("Printing deadlines by stream");
        tasksData.stream()
                .filter(t -> t instanceof Deadline)
                .forEach(System.out::println);
    }

}
