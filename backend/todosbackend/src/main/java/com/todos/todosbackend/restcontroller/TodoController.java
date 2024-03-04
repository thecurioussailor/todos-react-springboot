package com.todos.todosbackend.restcontroller;

import com.todos.todosbackend.models.Todo;
import com.todos.todosbackend.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos(){
                return todoRepository.findAll();
    }


    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo){

        Todo createTodo = todoRepository.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTodo);
    }
}
