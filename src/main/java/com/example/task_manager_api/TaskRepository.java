package com.example.task_manager_api;

import com.example.task_manager_api.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
