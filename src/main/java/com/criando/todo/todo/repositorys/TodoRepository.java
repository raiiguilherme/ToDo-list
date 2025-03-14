package com.criando.todo.todo.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.criando.todo.todo.entities.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    
}
