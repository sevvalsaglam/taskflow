package com.workintech.taskflow.dto;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;
    private String taskName;
    private LocalDate dueDate;
    private boolean completed;
    private Long userId; // İlgili kullanıcıyı temsil eder

    // Constructor
    public TaskDTO(Long id, String taskName, LocalDate dueDate, boolean completed, Long userId) {
        this.id = id;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.completed = completed;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
