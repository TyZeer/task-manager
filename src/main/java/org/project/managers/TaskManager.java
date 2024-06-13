package org.project.managers;

import lombok.Getter;
import lombok.Setter;
import org.project.tasks.Epic;
import org.project.tasks.SubTask;
import org.project.tasks.Task;

import java.util.*;
import java.util.concurrent.StructuredTaskScope;
@Getter
@Setter
public class TaskManager {

    private Map<Long, Task> tasksMap = new HashMap<>();//Список Тасков
    private Map<Long, Epic> epicsMap = new HashMap<>();//Список Эпиков
    private Map<Long, SubTask> subtasksMap = new HashMap<>();//Список Подзадач

    private Long uniqueIdCounter = 1L;//Cчетчик для новых АЙДИ
    //Методы для Тасков
    public List<Task> getAllTasks(){
        return new ArrayList<>(tasksMap.values());
    }

    public Task getTaskById(Long taskId) {
        return tasksMap.get(taskId);
    }

    public void createTask(Task task) {
        task.setId(uniqueIdCounter);
        uniqueIdCounter++;
        tasksMap.put(task.getId(), task);
    }

    public void updateTask(Task newTask){
        tasksMap.put(newTask.getId(), newTask);
    }

    public void deleteTaskById(Long taskId) {
        tasksMap.remove(taskId);
    }
    //Методы для Эпиков
    public List<Epic> getAllEpics(){
        return new ArrayList<>(epicsMap.values());
    }
    public Epic getEpicById(Long epicId) {
        return epicsMap.get(epicId);
    }

    public void createEpic(Epic epic) {
        epicsMap.put(epic.getId(), epic);
    }

    public void updateEpic(Epic newEpic) {
        epicsMap.put(newEpic.getId(), newEpic);
    }

    public void deleteEpicById(Long epicId) {
        epicsMap.remove(epicId);
    }
    //Методы для Подзадач
    public List<SubTask> getAllSubTasks(){
        return new ArrayList<>(subtasksMap.values());
    }




}
