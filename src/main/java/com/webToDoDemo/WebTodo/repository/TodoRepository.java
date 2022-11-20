package com.webToDoDemo.WebTodo.repository;

import com.webToDoDemo.WebTodo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
