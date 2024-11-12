package com.workintech.taskflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "task_categories", schema = "s20project")
public class TaskCategory {
    @Id
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
