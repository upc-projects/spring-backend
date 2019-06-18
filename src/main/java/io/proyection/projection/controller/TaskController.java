package io.proyection.projection.controller;

import io.proyection.projection.domain.Task;
import io.proyection.projection.service.MapValidationErrorService;
import io.proyection.projection.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewtask(@Valid @RequestBody Task task, BindingResult result, Principal principal){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        Task task1 = taskService.saveOrUpdateTask(task, principal.getName());
        return new ResponseEntity<Task>(task1, HttpStatus.CREATED);
    }


    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable Long taskId, Principal principal){

        Task task = taskService.findTaskById(taskId, principal.getName());

        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Task> getAlltasks(Principal principal){return taskService.findAllTask(principal.getName());}


    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deletetask(@PathVariable Long taskId, Principal principal){
        taskService.deleteTaskByIdentifier(taskId, principal.getName());

        return new ResponseEntity<String>("task with ID: '"+taskId+"' was deleted", HttpStatus.OK);
    }
}
