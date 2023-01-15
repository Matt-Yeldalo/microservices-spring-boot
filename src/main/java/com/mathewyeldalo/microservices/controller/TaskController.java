package com.mathewyeldalo.microservices.controller;

import com.mathewyeldalo.microservices.dto.TaskRequest;
import com.mathewyeldalo.microservices.dto.TaskResponse;
import com.mathewyeldalo.microservices.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {
  private final TaskService taskService;

  // Create task
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody TaskRequest taskRequest){
      taskService.createTask(taskRequest);
  }

  // Get tasks
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<TaskResponse> getTasks(){
    return taskService.getTasks();
  }
}
