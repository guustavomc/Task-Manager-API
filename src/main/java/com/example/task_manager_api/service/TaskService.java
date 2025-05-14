package com.example.task_manager_api.service;

import com.example.task_manager_api.model.Task;
import com.example.task_manager_api.model.TaskStatus;
import com.example.task_manager_api.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(long id){
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task with ID " + id + " not found");
        }
        try {
            taskRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete task with ID " + id);
        }
    }

    public Task updateTask(long id, Task updatedTask) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTaskName(updatedTask.getTaskName());
                    existingTask.setDescription(updatedTask.getDescription());
                    existingTask.setDueDate(updatedTask.getDueDate());
                    existingTask.setStatus(updatedTask.getStatus());
                    return taskRepository.save(existingTask);
                })
                .orElseThrow(() -> new RuntimeException("Task with ID " + id + " not found"));
    }

    public List<Task> getTaskWithStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }




}
