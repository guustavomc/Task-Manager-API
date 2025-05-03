package com.example.task_manager_api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/task")
public class TaskController {

    @GetMapping
    public String getTask() {
        return "test";
    }
    
    
}
