package com.webToDoDemo.WebTodo.service;

import com.webToDoDemo.WebTodo.config.TodoConfig;
import com.webToDoDemo.WebTodo.model.Todo;
import com.webToDoDemo.WebTodo.model.TodoValidator;
import com.webToDoDemo.WebTodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServices {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoValidator todoValidator;

    public List<Todo> findAll(Integer limit){
        return Optional.ofNullable(limit).map(value->todoRepository.findAll(PageRequest.of(0,value)).getContent()).orElseGet(()->todoRepository.findAll());
    }
    public Todo add(Todo todo){
        if (todoValidator.isValid(todo)){
            return todoRepository.save(todo);
        }
        return null;
    }
}
