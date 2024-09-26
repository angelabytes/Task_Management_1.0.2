package com.example.Task_Management_102.service;

import com.example.Task_Management_102.repository.TaskRepository;
import com.example.Task_Management_102.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

   private List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    private Optional<Task> getTaskById(Long id) {
       return taskRepository.findById(id);
    }

    private Task createTask(Task task) {
       return taskRepository.save(task);
    }
    private Task updateTask(Long id, Task updateTask) {
       return taskRepository.findById(id)
               .map(task -> {
                   task.setTitle(updateTask.getTitle());
                   task.setDescription(updateTask.getDescription());
                   task.setStatus(updateTask.getStatus());
                   return taskRepository.save(task);
               })
               .orElseThrow(() -> new RuntimeException("Task not found"));
    }
    private void deleteTask(Long id) {
       taskRepository.deleteById(id);
    }
}
