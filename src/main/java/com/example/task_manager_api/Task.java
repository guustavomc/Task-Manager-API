package com.example.task_manager_api;

public class Task {

    private String taskName;
    private String description;

    private TaskStatus status;
    
    private String dueDate;

    private String[] tags;


    public Task(String taskName, String description, TaskStatus status, String dueDate, String[] tags){
        this.taskName=taskName;
        this.description=description;
        this.status=status;
        this.dueDate=dueDate;
        this.tags=tags;
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
    public String[] getTags() {
        return tags;
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
    public void setTags(String[] tags) {
        this.tags = tags;
    }
    
}
