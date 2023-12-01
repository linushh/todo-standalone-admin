package com.example.todoappstandaloneadmin.controller;

import com.example.todoappstandaloneadmin.entity.TodoEntity;
import com.example.todoappstandaloneadmin.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin("http://localhost:5174/")
public class RestController {
    private final TodoService theService;

    @Autowired
    public RestController(TodoService service) {

        this.theService = service;
    }

    @GetMapping("/getall")
    public List<TodoEntity> getAllTodos() {

        return theService.getAllTodos();
    }

    @GetMapping("/getbyid/{id}")
    public TodoEntity getById(@PathVariable String id) {

        return theService.getById(id);
    }

    @PostMapping("/add")
    public String addTodo(@RequestBody TodoEntity task) {

        return theService.addTodo(task);
    }

    @PutMapping("/update/{id}")
    public String updateTask(@RequestBody TodoEntity todo, @PathVariable String id) {

        return theService.updateById(todo, id);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin("http://localhost:5174/")
    public String removeById(@PathVariable String id){

        return theService.removeTodo(id);
    }
}
