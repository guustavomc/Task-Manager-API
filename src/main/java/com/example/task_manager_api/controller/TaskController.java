package com.example.task_manager_api.controller;

import com.example.task_manager_api.model.Task;
import com.example.task_manager_api.model.TaskRequest;
import com.example.task_manager_api.model.TaskStatus;
import com.example.task_manager_api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
@RequestMapping("/api/task")
@Validated
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid TaskRequest taskRequest) {
        Task task= taskService.saveTask(taskRequest);
        return ResponseEntity.ok(task);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeTask(@PathVariable("id") long id){
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") long id, @RequestBody Task task){
        try {
            Task updatedTask = taskService.updateTask(id, task);
            return ResponseEntity.ok(task);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(task);
        }
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskWithStatus(@PathVariable("status")TaskStatus status){
        return taskService.getTaskWithStatus(status);
    }
}
