package org.project.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Epic extends Task{

    private List<SubTask> subTasks;

    public Epic(long id, String name, String description, TaskStatus status) {
        super(id, name, description, status);
        this.subTasks = new ArrayList<>();
    }


    public void addSubTask(SubTask subTask){

        subTasks.add(subTask);
    }
    public void deleteSubTask(Long subTaskId){
        subTasks.removeIf(subTask -> Objects.equals(subTask.getId(), subTaskId));
    }
}
