package com.criando.todo.todo.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document(collection = "todo") //é o "Entity" do JPA
public class Todo implements Serializable{
    



    @Id
    private String id;

    private String name;
    private String description;
    private boolean status;

    public Todo(String id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }
    
    public Todo(String name, String description, boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }
    
  

    
}
