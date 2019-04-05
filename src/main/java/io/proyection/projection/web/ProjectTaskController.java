package io.proyection.projection.web;

import io.proyection.projection.domain.ProjectTask;
import io.proyection.projection.service.IProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/boards")
@CrossOrigin
public class ProjectTaskController {

    @Autowired
    private IProjectTaskService projectTaskService;

    @PostMapping("")
    public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ProjectTask newPT = projectTaskService.save(projectTask);

        return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("")
    public Iterable<ProjectTask> getAllPTs() {
        return projectTaskService.findAll();
    }

    @GetMapping("/{projectTask_id}")
    public ResponseEntity<?> getPTById(@PathVariable Long projectTask_id){
        ProjectTask projectTask = projectTaskService.findById((projectTask_id));
        return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
    }

    @DeleteMapping("/{projectTask_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long projectTask_id){
        projectTaskService.delete(projectTask_id);

        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }

    @RequestMapping("/change_status")
    public ResponseEntity<?> addUser(@RequestBody HashMap<String,String> mapper){
        Long task_id = Long.parseLong(mapper.get("user_id"));
        int status = Integer.parseInt(mapper.get("status_id"));

        projectTaskService.changeStatus(task_id,status);

        return new ResponseEntity<String>("Status changed", HttpStatus.OK);
    }
}
