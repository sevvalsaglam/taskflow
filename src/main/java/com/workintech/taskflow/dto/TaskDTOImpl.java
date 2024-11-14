package com.workintech.taskflow.dto;


import com.workintech.taskflow.entity.Task;

public class TaskDTOImpl {

    public static TaskDTO fromEntity(Task task) {
        if (task == null) {
            return null; // null kontrolü
        }

        // Entity'den DTO'ya dönüşüm
        return new TaskDTO(
                task.getId(),
                task.getTaskName(),
                task.getDueDate(),
                task.getCompleted(),
                task.getUser().getId() // User'dan ID alınır
        );
    }

    public static Task toEntity(TaskDTO taskDTO) {
        if (taskDTO == null) {
            return null; // null kontrolü
        }

        // DTO'dan Entity'ye dönüşüm
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTaskName(taskDTO.getTaskName());
        task.setDueDate(taskDTO.getDueDate());
        task.setCompleted(taskDTO.isCompleted());
        // User'ın ID'si ile User nesnesi elde edilip ilişkilendirilebilir
        return task;
    }
}
