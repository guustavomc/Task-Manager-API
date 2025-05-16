package com.example.task_manager_api.repository;

import com.example.task_manager_api.model.Task;
import com.example.task_manager_api.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByDueDateBefore(LocalDate date);

}
