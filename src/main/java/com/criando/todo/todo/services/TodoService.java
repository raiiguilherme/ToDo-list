package com.criando.todo.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criando.todo.todo.entities.Todo;
import com.criando.todo.todo.repositorys.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll(){
        List<Todo> list =  repository.findAll();
        return list;

    }

    public List<Todo> addTodo(Todo todo){
        repository.insert(todo);
        return findAll();
        
    }

    public Todo findById(String id){
    
      Optional<Todo> op = repository.findById(id);
      return op.get();

    }

    public Todo alter(Todo todo){
        Optional<Todo> op = repository.findById(todo.getId());//capturando um to-do pelo id (virá em optional)
        Todo novo = op.get(); //transformando o optional em to-do
        alterTodo(novo, todo); //alterando as informações
        return repository.save(novo); //salvando
      
      

    }

     public void alterTodo(Todo novo, Todo todo){
        //alterando o nome, email e o status
        novo.setName(todo.getName());
        novo.setDescription(todo.getDescription());
        novo.setStatus(todo.isStatus());
       
        
    }

    public void delete(String id){

        repository.deleteById(id);

    }




    
}
