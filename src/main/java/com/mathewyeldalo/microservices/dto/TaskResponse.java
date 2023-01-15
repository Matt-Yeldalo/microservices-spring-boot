package com.mathewyeldalo.microservices.dto;

import com.mathewyeldalo.microservices.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

  private String id;
  private String name;
  private String description;
}
