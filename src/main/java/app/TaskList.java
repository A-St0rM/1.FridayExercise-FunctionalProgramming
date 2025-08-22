package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList <T extends Task> implements Iterable<T>{

    private final List<T> tasks = new ArrayList<>();

    //Add tasks to the list.
    public void addTask(T task){
        tasks.add(task);
    }

    //Filter tasks based on a keyword in the title or description.
    public List<T> filterByKeyword(String keyword) {
        return tasks.stream()
                .filter(task -> task.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        task.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    //Sort tasks by due date.
    public List<T> sortByDueDate() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

    //Get tasks that are due today.
    public List<T> tasksDueToday(){
        LocalDate todaysDate = LocalDate.now();
        return tasks.stream()
                .filter(task -> todaysDate.equals(task.getDueDate()))
                .collect(Collectors.toList());
    }

    //Get tasks that are overdue.
    public List<T> tasksOverdue(){
        LocalDate todaysDate = LocalDate.now();

        return tasks.stream()
                .filter(task -> task.getDueDate().isBefore(todaysDate))
                .collect(Collectors.toList());
    }

    //Print the list of tasks.
    public void printTasks(){
        tasks.forEach(System.out::println);
    }

    @Override
    public Iterator<T> iterator() {
        return tasks.iterator();
    }

}
