package com.example.task_manager_api;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    
    private String dueDate;
    @ElementCollection
    private List tags;


    public Task(String taskName, String description, TaskStatus status, String dueDate, List tags){
        this.taskName=taskName;
        this.description=description;
        this.status=status;
        this.dueDate=dueDate;
        this.tags=tags;
    }

    public Long getId() {
        return id;
    }
    public String getTaskName() {
        return taskName;
    }
    public String getDescription() {
        return description;
    }
    public TaskStatus getStatus() {
        return status;
    }
    public String getDueDate() {
        return dueDate;
    }

    public List getTags() {
        return tags;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setTags(List tags) {
        this.tags = tags;
    }
}
