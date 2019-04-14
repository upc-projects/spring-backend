package io.proyection.projection.web;

import io.proyection.projection.domain.Task;
import io.proyection.projection.service.ITaskService;
import io.proyection.projection.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @PostMapping("")
    public ResponseEntity<?> addTask(@Valid @RequestBody Task task, BindingResult result) {

        ResponseEntity<?> errorMap = Commons.getResponseEntity(result);
        if (errorMap != null) return errorMap;

        Task newPT = taskService.save(task);

        return new ResponseEntity<Task>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("")
    public Iterable<Task> getAllTasks() {
        return taskService.findAll();
    }


    @GetMapping("/{task_id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long task_id) {
        Task task = taskService.findById((task_id));
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    @DeleteMapping("/{task_id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long task_id) {
        taskService.delete(task_id);

        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }

    @RequestMapping("/change_status")
    public ResponseEntity<?> changeStatusTask(@RequestBody HashMap<String, String> mapper) {
        Long task_id = Long.parseLong(mapper.get("user_id"));
        int status = Integer.parseInt(mapper.get("status_id"));

        taskService.changeStatus(task_id, status);

        return new ResponseEntity<String>("Status changed", HttpStatus.OK);
    }
}
