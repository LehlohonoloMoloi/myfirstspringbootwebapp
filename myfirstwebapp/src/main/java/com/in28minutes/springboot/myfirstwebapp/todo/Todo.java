package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TODO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "USERNAME")
    private String username;
    @Size(min = 10, message = "Enter atleast 10 characters")
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TARGET_DATE")
    private LocalDate targetDate;
    @Column(name = "DONE")
    private boolean done;
}
