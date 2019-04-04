package io.proyection.projection.web;

import io.proyection.projection.domain.Project;
import io.proyection.projection.domain.User;
import io.proyection.projection.service.ProjectService;
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
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> addProject(@Valid @RequestBody Project project, BindingResult result) {

        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Project newProject = projectService.save(project);

        return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
    }

    @GetMapping("")
    public Iterable<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{project_id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long project_id){
        Project project = projectService.findById((project_id));
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @DeleteMapping("/{project_id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long project_id){
        projectService.delete(project_id);

        return new ResponseEntity<String>("Project deleted", HttpStatus.OK);
    }

    @PostMapping("/addUser/{user_id}")
    public ResponseEntity<?> addUser(@PathVariable Long user_id, BindingResult result) {
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
       Project project = projectService.addUser(user_id);
       return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

}
