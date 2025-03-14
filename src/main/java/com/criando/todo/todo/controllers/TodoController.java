package com.criando.todo.todo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criando.todo.todo.entities.Todo;
import com.criando.todo.todo.services.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    private TodoService service;
    
    @GetMapping
    public ResponseEntity<List<Todo>> findAll(){
        List<Todo> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<List<Todo>> add(@RequestBody Todo todo){
       List<Todo> lis = service.addTodo(todo); 
       return ResponseEntity.ok(lis);
         
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable String id){
        
        Todo todo = service.findById(id);
        return ResponseEntity.ok(todo);
    }

    @PutMapping(value = "/alter/{id}")//caminho da requisição
    public ResponseEntity<Todo> alter(@RequestBody Todo todo, @PathVariable String id){
       todo.setId(id); //para garantir que tenha o mesmo id
        Todo nova = service.alter(todo); 
       return ResponseEntity.ok(nova);

    }

    @DeleteMapping(value = "/delete/{id}")//deleção sera por base no ID
    public ResponseEntity<List<Todo>> delete(@PathVariable String id){
        
        service.delete(id);//deletando
        List<Todo> lis = service.findAll(); //retornando a lista com todas as ToDos remanescentes 
        return ResponseEntity.ok(lis);
        

    }   

}


