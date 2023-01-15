package com.mathewyeldalo.microservices.repository;

import com.mathewyeldalo.microservices.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
