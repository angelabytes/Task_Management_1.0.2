package com.example.Task_Management_102.repository;

import com.example.Task_Management_102.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
