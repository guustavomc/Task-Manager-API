package com.example.task_manager_api;

import com.example.task_manager_api.Task;
import com.example.task_manager_api.TaskStatus;
import com.example.task_manager_api.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskRepository taskRepository;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void testGetAllTasks(){
        List tags = new ArrayList();
        tags.add("tag 1");
        Task task1 = new Task("Task 1","Description 1", TaskStatus.TODO,"november",tags);
        Task task2 = new Task("Task 2","Description 2", TaskStatus.TODO,"december",tags);

        when(taskRepository.findAll()).thenReturn(List.of(task1, task2));
        List<Task> tasks = taskService.getAllTasks();

        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();

    }
}
