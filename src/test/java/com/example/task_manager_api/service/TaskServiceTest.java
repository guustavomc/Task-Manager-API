package com.example.task_manager_api.service;

import com.example.task_manager_api.model.Task;
import com.example.task_manager_api.model.TaskStatus;
import com.example.task_manager_api.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testGetAllExistingTasks(){
        List tags = new ArrayList();
        tags.add("tag 1");
        Task task1 = new Task("Task 1","Description 1", TaskStatus.TODO,"november",tags);
        Task task2 = new Task("Task 2","Description 2", TaskStatus.TODO,"december",tags);

        when(taskRepository.findAll()).thenReturn(List.of(task1, task2));
        List<Task> tasks = taskService.getAllTasks();

        assertEquals(2, tasks.size());
        verify(taskRepository, times(1)).findAll();

    }

    @Test
    void testCreateNewTask(){
        List tags = new ArrayList();
        tags.add("tag 1");
        Task task1 = new Task("Task 1","Description 1", TaskStatus.TODO,"november",tags);

        when(taskRepository.save(task1)).thenReturn(task1);

        assertEquals(taskService.saveTask(task1), task1);
    }

    @Test
    void taskNotFound_ThrowRuntimeException_WhenDeleteTask(){
        long taskId = 1L;
        when(taskRepository.existsById(taskId)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> taskService.deleteTask(taskId));

        assertEquals("Task with ID 1 not found", exception.getMessage());
    }

    @Test
    void deleteTask_WhenDeleteTask(){
        long taskId = 1L;
        when(taskRepository.existsById(taskId)).thenReturn(true);
        doNothing().when(taskRepository).deleteById(taskId);

        assertDoesNotThrow(() -> taskService.deleteTask(taskId));

    }

    @Test
    void failToDelete_ThrowRunTimeException_WhenDeleteTask(){
        long taskId = 1L;
        when(taskRepository.existsById(taskId)).thenReturn(true);
        doThrow(new RuntimeException("DB error")).when(taskRepository).deleteById(taskId);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> taskService.deleteTask(taskId));

        assertEquals("Failed to delete task with ID 1", exception.getMessage());
    }

    @Test
    void updateTask_WhenUpdateTask(){
        long taskId = 1L;
        List<String> tags = List.of("tag 1");

        Task currentTask = new Task("Task 1","Description 1", TaskStatus.TODO,"november",tags);
        currentTask.setId(taskId);

        Task updatesTask = new Task("Task 2","Description 2", TaskStatus.TODO,"december",tags);
        when(taskRepository.findById(taskId)).thenReturn(java.util.Optional.of(updatesTask));
        when(taskRepository.save(any(Task.class))).thenAnswer(i -> i.getArgument(0));

        Task result = taskService.updateTask(taskId,updatesTask);
        assertEquals("Task 2",result.getTaskName());

    }

    @Test
    void taskNotFound_ThrowRuntimeException_WhenUpdateTask(){
        long taskId = 1L;
        Task task = new Task("New Task", "New Desc", TaskStatus.DONE, "december", List.of("tag"));

        when(taskRepository.findById(taskId)).thenReturn(java.util.Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> taskService.updateTask(taskId,task));

        assertEquals("Task with ID 1 not found", exception.getMessage());


    }
}
