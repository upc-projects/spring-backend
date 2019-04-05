package io.proyection.projection.web;

import io.proyection.projection.domain.Project;
import io.proyection.projection.domain.User;
import io.proyection.projection.service.ProjectService;
import io.proyection.projection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

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

    @RequestMapping("add_user")
    public ResponseEntity<?> addUser(@RequestBody HashMap<String,String> mapper){

        Long user_id = Long.parseLong(mapper.get("user_id"));
        Long project_id = Long.parseLong(mapper.get("project_id"));

        projectService.addUser(user_id,project_id);

        return new ResponseEntity<String>("Project added an User", HttpStatus.OK);
    }

}
