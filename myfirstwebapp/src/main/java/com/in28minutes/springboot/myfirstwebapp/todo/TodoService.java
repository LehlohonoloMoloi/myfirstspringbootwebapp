package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
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
        return todoRepository.findByUsername(username);
    }

    public void addTodo(Todo todo){
        todoRepository.save(todo);
    }

    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }

    public Todo findById(int id) {
        return todoRepository.findById(id).get();
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
