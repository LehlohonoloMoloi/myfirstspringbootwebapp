package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private int id;
    private String username;
    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
