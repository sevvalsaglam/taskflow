package com.workintech.taskflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tasks", schema = "s20project")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Task name is required")
    @Column(name = "task_name")
    private String taskName;

    @Future(message = "Due date must be in the future")
    @NotNull(message = "Due date is required")
    @Column(name = "due_date")
    private LocalDate dueDate;

    @NotNull
    @Column(name = "completed")
    private Boolean completed;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "task_categories",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

}
