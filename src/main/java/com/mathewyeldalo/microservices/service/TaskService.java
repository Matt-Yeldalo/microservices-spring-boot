package com.mathewyeldalo.microservices.service;

import com.mathewyeldalo.microservices.dto.TaskRequest;
import com.mathewyeldalo.microservices.dto.TaskResponse;
import com.mathewyeldalo.microservices.model.Task;
import com.mathewyeldalo.microservices.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {
  // Repository injection using lombok "RequiredArgsConstructor", will automatically inject the class during constructor runtime.
  private final TaskRepository taskRepository;
  public void createTask(TaskRequest taskRequest){
    // Use builder to create a task using the request, must be in the format of taskRequest
    Task task = Task.builder()
            .name(taskRequest.getName())
            .description(taskRequest.getDescription())
            .build();
    // Save the newly created task to the database
    taskRepository.save(task);
    // Using the "Slf4j" package to log information
    log.info("Task {} was successfully added.", task.getName());
  }

  public List<TaskResponse> getTasks() {
    // Get all tasks from databse
    List<Task> tasks = taskRepository.findAll();
    // Map list of tasks into a list of taskResponses
    return tasks.stream().map(this::mapToTaskResponse).toList();
  }
  // Method to help map general tasks to taskResponses
  private TaskResponse mapToTaskResponse(Task task){
    return TaskResponse.builder()
            .id(task.getId())
            .name(task.getName())
            .description(task.getDescription())
            .build();
  }
}

