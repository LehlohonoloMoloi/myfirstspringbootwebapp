package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    private TodoService todoService;
    @RequestMapping("list-todos")
    public String listALlTodos(ModelMap modelMap){
        List<Todo> todos = todoService.findByUser("in28minutes");
        modelMap.addAttribute("todos", todos);
        return "listTodos";
    }
}
