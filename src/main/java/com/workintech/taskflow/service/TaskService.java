package com.workintech.taskflow.service;

import com.workintech.taskflow.entity.Task;
import com.workintech.taskflow.exception.ApiException;
import com.workintech.taskflow.repository.TaskRepository;
import com.workintech.taskflow.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        if (DateUtil.isBeforeToday(task.getDueDate())) {
            throw new IllegalArgumentException("Due date cannot be before today");
        }
        return taskRepository.save(task);
    }

    public Task findTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ApiException("Task not found", HttpStatus.NOT_FOUND));
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = findTaskById(id);
        task.setTaskName(taskDetails.getTaskName());
        task.setCategories(taskDetails.getCategories());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = findTaskById(id);
        taskRepository.delete(task);
    }
}


