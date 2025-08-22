package app;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        TaskList<Task> taskList = new TaskList<>();

        //Create instances of Task and GardenTask and add them to a TaskList.
        Task task1 = new Task("Clean the house", "Clean the sofa and kitchen", LocalDate.now().plusDays(2));
        Task task2 = new Task("Finish report", "Submit the Java report", LocalDate.now().plusDays(1));
        GardenTask task3 = new GardenTask("Water plants", "Water the roses and tulips", LocalDate.now(), "Backyard");
        GardenTask task4 = new GardenTask("Trim hedges", "Trim the front garden hedge", LocalDate.now().minusDays(1), "Front yard");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(task4);

        System.out.println("All tasks:");
        taskList.printTasks();

        // Demonstrate the usage of lambda expressions and streams for filtering tasks (keyword: "water")
        System.out.println("Filtered by keyword 'water':");
        List<Task> filtered = taskList.filterByKeyword("water");
        filtered.forEach(System.out::println);

        // Demonstrate sorting tasks by due date
        System.out.println("Sorted by due date:");
        List<Task> sorted = taskList.sortByDueDate();
        sorted.forEach(System.out::println);

        // Get tasks due today
        System.out.println("Tasks due today:");
        taskList.tasksDueToday().forEach(System.out::println);

        // Get overdue tasks
        System.out.println("Overdue tasks:");
        taskList.tasksOverdue().forEach(System.out::println);

    }
}