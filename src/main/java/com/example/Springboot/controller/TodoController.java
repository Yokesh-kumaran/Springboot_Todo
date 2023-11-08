package com.example.Springboot.controller;

import com.example.Springboot.model.Todo;
import com.example.Springboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo/all")
    public List<Todo> getAllTodos(){
        return todoRepository.findAllTodos();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodoById(@PathVariable int id){
        return todoRepository.findById(id);
    }

    @PostMapping("/todo")
    public List<Todo> createTodo(@RequestBody Todo todo){
        return todoRepository.insert(todo);
    }

    @PutMapping("/todo")
    public List<Todo> updateTodo(@RequestBody Todo todo){
        return todoRepository.update(todo);
    }

    @DeleteMapping("/todo/{id}")
    public List<Todo> deleteTodoById(@PathVariable int id){
        return todoRepository.delete(id);
    }
}
