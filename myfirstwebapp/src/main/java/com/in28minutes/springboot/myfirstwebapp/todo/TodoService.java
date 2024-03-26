package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;
    static {
        todos.add(new Todo(++todoCount, "in28minutes","Learn AWS",
                LocalDate.now().plusYears(1), false ));
        todos.add(new Todo(++todoCount, "in28minutes","Learn DevOps",
                LocalDate.now().plusYears(2), false ));
        todos.add(new Todo(++todoCount, "in28minutes","Learn Full Stack Development",
                LocalDate.now().plusYears(3), false ));
    }

    public List<Todo> findByUser(String username){
        return todos.stream()
                .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone){
        Todo todo = new Todo(++todoCount, username, description, targetDate, isDone);
        todos.add(todo);
    }

    public void deleteById(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .get();
    }

    public void updateTodo(Todo todo) {
        Todo updateTodo = findById(todo.getId());
        updateTodo.setDescription(todo.getDescription());
    }
}
