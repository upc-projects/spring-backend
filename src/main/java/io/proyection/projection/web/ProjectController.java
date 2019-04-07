package io.proyection.projection.web;

import io.proyection.projection.domain.Project;
import io.proyection.projection.domain.Team;
import io.proyection.projection.service.IProjectService;
import io.proyection.projection.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUserService userService;

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

    @PostMapping(value="/{id_project}/team")
    public ResponseEntity<?> addTeamToProject(@Valid @RequestBody Team team, @PathVariable Long id_project){

        Team newTeam = projectService.addTeam(team,id_project);
        return new ResponseEntity<Team>(newTeam, HttpStatus.CREATED);
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

        Long userId = Long.parseLong(mapper.get("user_id"));
        Long projectId = Long.parseLong(mapper.get("project_id"));

        projectService.addUser(userId,projectId);

        return new ResponseEntity<String>("Project added an User", HttpStatus.OK);
    }

}
