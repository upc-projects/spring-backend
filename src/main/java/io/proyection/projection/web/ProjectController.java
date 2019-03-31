package io.proyection.projection.web;

import io.proyection.projection.domain.Project;
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
@RequestMapping("/api/project")
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

    @GetMapping("/all")
    public Iterable<Project> getAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/{p_id}")
    public ResponseEntity<?> getProjectById(@PathVariable Long p_id){
        Project project = projectService.findById((p_id));
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @DeleteMapping("/{p_id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long p_id){
        projectService.delete(p_id);

        return new ResponseEntity<String>("Project deleted", HttpStatus.OK);
    }
}
