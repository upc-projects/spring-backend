package io.proyection.projection.controller;

import io.proyection.projection.domain.Task;
import io.proyection.projection.exception.ResourceNotFoundException;
import io.proyection.projection.repository.TaskRepository;
import io.proyection.projection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;


    @PostMapping("/users/{userId}/tasks")
    public Task createTask(@PathVariable(value = "userId") Long userId,
                           @Valid @RequestBody Task task) {
        return userRepository.findById(userId).map(user -> {
            task.setUser(user);
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
    }

    @GetMapping("/users/{userId}/tasks")
    public Page<Task> getAllTasksByUserId(@PathVariable(value = "userId") Long userId,
                                          Pageable pageable) {
        return taskRepository.findByUserId(userId, pageable);
    }

    @GetMapping("/tasks/{taskId}")
    public Task getTaskById(@PathVariable(value = "taskId") Long taskId) {
        return taskRepository.getById(taskId);
    }

    @GetMapping("/tasks")
    public Page<Task> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @PutMapping("/users/{userId}/tasks/{taskId}")
    public Task updateTask(@PathVariable(value = "userId") Long userId,
                           @PathVariable(value = "taskId") Long taskId,
                           @Valid @RequestBody Task taskRequest) {

        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("UserId " + userId + " not found");
        }

        return taskRepository.findById(taskId).map(task -> {

            task.setSummary(taskRequest.getSummary());
            task.setStatus(taskRequest.getStatus());
            task.setAcceptanceCriteria(taskRequest.getAcceptanceCriteria());
            task.setLimitDate(taskRequest.getLimitDate());
            task.setModifiedBy(taskRequest.getUser().getUsername());
            task.setDone(taskRequest.isDone());
            return taskRepository.save(task);
        }).orElseThrow(() -> new ResourceNotFoundException("TaskId " + taskId + "not found"));
    }


    @DeleteMapping("/users/{userId}/tasks/{taskId}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "userId") Long userId,
                                           @PathVariable(value = "taskId") Long taskId) {
        return taskRepository.findByIdAndUserId(taskId, userId).map(task -> {
            taskRepository.delete(task);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId + " and userId " + userId));
    }
}
