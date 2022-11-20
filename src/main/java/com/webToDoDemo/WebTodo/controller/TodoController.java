package com.webToDoDemo.WebTodo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.webToDoDemo.WebTodo.model.Todo;
import com.webToDoDemo.WebTodo.service.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.OpenOption;
import java.util.Optional;

@Controller
public class TodoController {
    @Autowired
    TodoServices todoServices;

    @GetMapping("/listTodo")
    public String index(@RequestParam(value = "limit",required = false) Integer limit, Model model){
        model.addAttribute("todoList",todoServices.findAll(limit));
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String add(Model model){
        model.addAttribute("todo",new Todo());
        return "addTodo";
    }
    @PostMapping("/addTodo")
    public String add(@ModelAttribute Todo todo){
        return Optional.ofNullable(todoServices.add(todo)).map(t->"success").orElse("failed");
    }
}
