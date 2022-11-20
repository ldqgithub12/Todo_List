package com.webToDoDemo.WebTodo.config;

import com.webToDoDemo.WebTodo.model.Todo;
import com.webToDoDemo.WebTodo.model.TodoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

@Configuration
public class TodoConfig {
    @Bean
    public TodoValidator validator() {
        return new TodoValidator();
    }
}
