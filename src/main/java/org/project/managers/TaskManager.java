package org.project.managers;


import org.project.tasks.Epic;
import org.project.tasks.SubTask;
import org.project.tasks.Task;
import org.project.tasks.TaskStatus;

import java.util.*;


public class TaskManager {

    private Map<Long, Task> tasksMap = new HashMap<>();//Список Тасков
    private Map<Long, Epic> epicsMap = new HashMap<>();//Список Эпиков
    private Map<Long, SubTask> subtasksMap = new HashMap<>();//Список Подзадач

    private Long uniqueIdCounter = 1L;//Cчетчик для новых АЙДИ

    public Map<Long, Task> getTasksMap() {
        return tasksMap;
    }

    public void setTasksMap(Map<Long, Task> tasksMap) {
        this.tasksMap = tasksMap;
    }

    public Map<Long, Epic> getEpicsMap() {
        return epicsMap;
    }

    public void setEpicsMap(Map<Long, Epic> epicsMap) {
        this.epicsMap = epicsMap;
    }

    public Map<Long, SubTask> getSubtasksMap() {
        return subtasksMap;
    }

    public void setSubtasksMap(Map<Long, SubTask> subtasksMap) {
        this.subtasksMap = subtasksMap;
    }

    public Long getUniqueIdCounter() {
        return uniqueIdCounter;
    }

    public void setUniqueIdCounter(Long uniqueIdCounter) {
        this.uniqueIdCounter = uniqueIdCounter;
    }

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

    public void deleteAllTasks(){
        tasksMap.clear();;
    }
    //Методы для Эпиков
    public List<Epic> getAllEpics(){
        return new ArrayList<>(epicsMap.values());
    }
    public Epic getEpicById(Long epicId) {
        return epicsMap.get(epicId);
    }

    public void createEpic(Epic epic) {
        epic.setId(uniqueIdCounter);
        uniqueIdCounter++;
        epicsMap.put(epic.getId(), epic);
    }

    public void updateEpic(Epic newEpic) {
        epicsMap.put(newEpic.getId(), newEpic);
    }

    public void deleteEpicById(Long epicId) {
        epicsMap.remove(epicId);
    }

    public void deleteAllEpics(){
        epicsMap.clear();
        subtasksMap.clear();
    }
    public void  changeEpicsStatus(Long epicId){

        boolean allDone = epicsMap.get(epicId).getSubTasks().stream().allMatch(subtask -> subtask.getStatus() == TaskStatus.DONE);
        boolean allNew = epicsMap.get(epicId).getSubTasks().stream().allMatch(subtask -> subtask.getStatus() == TaskStatus.NEW);
        if ( epicsMap.get(epicId).getSubTasks().isEmpty() || allNew) {
            epicsMap.get(epicId).setStatus(TaskStatus.NEW);
        } else if (allDone) {
            epicsMap.get(epicId).setStatus(TaskStatus.DONE);
        } else {
            epicsMap.get(epicId).setStatus(TaskStatus.IN_PROGRESS);;
        }
    }

    //Методы для Подзадач
    public List<SubTask> getAllSubTasks(){
        return new ArrayList<>(subtasksMap.values());
    }

    public List<SubTask> getAllSubTaskByEpicId(Long epicId){
        ArrayList<SubTask> epicsTasks =  new ArrayList<>();
        subtasksMap.values().forEach(subTask -> {
            if (subTask.getEpicId().equals(epicId)){
                epicsTasks.add(subTask);
            }
        });
        return epicsTasks;
    }
    public SubTask getSubTaskById(Long subTaskId) {
        return subtasksMap.get(subTaskId);
    }

    public void createSubTask(SubTask subTask) {
        subTask.setId(uniqueIdCounter);
        uniqueIdCounter++;
        epicsMap.get(subTask.getEpicId()).addSubTask(subTask);
        subtasksMap.put(subTask.getId(), subTask);
    }

    public void updateSubTask(SubTask newSubTask) {
        epicsMap.get(newSubTask.getEpicId()).addSubTask(newSubTask);
        subtasksMap.put(newSubTask.getId(), newSubTask);
    }

    public void deleteSubTaskById(Long subTaskId) {
        epicsMap.get(subtasksMap.get(subTaskId).getEpicId()).deleteSubTask(subTaskId);
        subtasksMap.remove(subTaskId);
    }

    public void deleteAllSubTasks(){
        subtasksMap.clear();
    }







}
