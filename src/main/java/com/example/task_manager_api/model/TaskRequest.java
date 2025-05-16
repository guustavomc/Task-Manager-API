package com.example.task_manager_api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class TaskRequest {

    @NotNull(message = "Task name is required")
    @Size(min = 3, max = 100, message = "Task name must be between 3 and 100 characters")
    private String taskName;

    private String description;

    @NotNull(message = "Status is required")
    private TaskStatus status;

    private String dueDate;

    private List<String> tags;

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

    public List<String> getTags() {
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

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
