package org.project.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Getter
@Setter
@AllArgsConstructor
public class Epic extends Task{

    private HashMap<Long, SubTask> subTaskHashMap;

    public Epic(long id, String name, String description, TaskStatus status) {
        super(id, name, description, status);
        this.subTaskHashMap = new HashMap<>();
    }


    public void addSubTask(SubTask subTask){
        subTaskHashMap.put(subTask.getId(), subTask);
    }
}
