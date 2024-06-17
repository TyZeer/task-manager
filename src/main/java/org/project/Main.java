package org.project;
import org.project.tasks.*;
import org.project.managers.TaskManager;
public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task = new Task("1", "name1", TaskStatus.NEW );
        Task task2 = new Task("3", "name1", TaskStatus.NEW );
        taskManager.createTask(task);
        taskManager.createTask(task2);
        System.out.println(taskManager.getAllTasks());
        Task task3 = new Task(2L, "3_update", "name1", TaskStatus.IN_PROGRESS);
        taskManager.updateTask(task3);
        System.out.println(taskManager.getAllTasks());
        taskManager.deleteTaskById(2L);
        System.out.println(taskManager.getAllTasks());
        taskManager.deleteAllTasks();
        System.out.println(taskManager.getAllTasks());
        Epic epic1 = new Epic(1, "first_epic", "name epic", TaskStatus.NEW);
        taskManager.createEpic(epic1);
        System.out.println(taskManager.getAllEpics());


    }
}